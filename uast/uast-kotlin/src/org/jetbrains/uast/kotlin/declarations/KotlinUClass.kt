/*
 * Copyright 2010-2016 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jetbrains.uast.kotlin

import com.intellij.psi.*
import com.intellij.psi.impl.light.LightPsiClassBuilder
import org.jetbrains.kotlin.asJava.classes.KtLightClass
import org.jetbrains.kotlin.asJava.classes.KtLightClassForFacade
import org.jetbrains.kotlin.asJava.classes.KtLightClassForScript
import org.jetbrains.kotlin.asJava.elements.KtLightMethod
import org.jetbrains.kotlin.load.java.JvmAbi
import org.jetbrains.kotlin.psi.*
import org.jetbrains.kotlin.utils.KotlinExceptionWithAttachments
import org.jetbrains.kotlin.utils.SmartList
import org.jetbrains.kotlin.utils.addIfNotNull
import org.jetbrains.kotlin.utils.addToStdlib.firstIsInstanceOrNull
import org.jetbrains.uast.*
import org.jetbrains.uast.internal.acceptList
import org.jetbrains.uast.kotlin.declarations.KotlinUIdentifier
import org.jetbrains.uast.kotlin.declarations.KotlinUMethod
import org.jetbrains.uast.kotlin.declarations.UastLightIdentifier
import org.jetbrains.uast.kotlin.kinds.KotlinSpecialExpressionKinds
import org.jetbrains.uast.visitor.UastVisitor

abstract class AbstractKotlinUClass(givenParent: UElement?) : KotlinAbstractUElement(givenParent), UClassTypeSpecific, UAnchorOwner {

    override val uastDeclarations by lz {
        mutableListOf<UDeclaration>().apply {
            addAll(fields)
            addAll(initializers)
            addAll(methods)
            addAll(innerClasses)
        }
    }

    open val ktClass: KtClassOrObject? get() = (psi as? KtLightClass)?.kotlinOrigin

    override val uastSuperTypes: List<UTypeReferenceExpression>
        get() = ktClass?.superTypeListEntries.orEmpty().mapNotNull { it.typeReference }.map {
            LazyKotlinUTypeReferenceExpression(it, this)
        }

    val delegateExpressions: List<UExpression>
        get() = ktClass?.superTypeListEntries.orEmpty()
            .filterIsInstance<KtDelegatedSuperTypeEntry>()
            .map { KotlinSupertypeDelegationUExpression(it, this) }

    override fun accept(visitor: UastVisitor) {
        if (visitor.visitClass(this)) return
        delegateExpressions.acceptList(visitor)
        annotations.acceptList(visitor)
        uastDeclarations.acceptList(visitor)
        visitor.afterVisitClass(this)
    }

    override val annotations: List<UAnnotation> by lz {
        (sourcePsi as? KtModifierListOwner)?.annotationEntries.orEmpty().map { KotlinUAnnotation(it, this) }
    }

    override fun equals(other: Any?) = other is AbstractKotlinUClass && psi == other.psi
    override fun hashCode() = psi.hashCode()

}

class KotlinSupertypeDelegationUExpression(override val sourcePsi: KtDelegatedSuperTypeEntry, givenParent: UElement?) :
    KotlinAbstractUExpression(givenParent), UExpressionList {

    override val psi: PsiElement? get() = sourcePsi

    val typeReference: UTypeReferenceExpression? by lazy {
        sourcePsi.typeReference?.let { KotlinUTypeReferenceExpression(it.toPsiType(this), it, this) }
    }

    val delegateExpression: UExpression? by lazy {
        sourcePsi.delegateExpression?.let { kotlinUastPlugin.convertElement(it, this, UExpression::class.java) as? UExpression }
    }

    override val expressions: List<UExpression>
        get() = listOfNotNull(typeReference, delegateExpression)

    override val kind: UastSpecialExpressionKind get() = KotlinSpecialExpressionKinds.SUPER_DELEGATION

}

open class KotlinUClass private constructor(
        psi: KtLightClass,
        givenParent: UElement?
) : AbstractKotlinUClass(givenParent), PsiClass by psi {

    final override val ktClass = psi.kotlinOrigin

    override val javaPsi: KtLightClass = psi

    override val sourcePsi: KtClassOrObject? = ktClass

    override val psi = unwrap<UClass, PsiClass>(psi)

    override fun getSourceElement() = sourcePsi ?: this

    override fun getOriginalElement(): PsiElement? = super.getOriginalElement()

    override fun getNameIdentifier(): PsiIdentifier? = UastLightIdentifier(psi, ktClass)

    override fun getContainingFile(): PsiFile? = unwrapFakeFileForLightClass(psi.containingFile)

    override val uastAnchor by lazy { getIdentifierSourcePsi()?.let { KotlinUIdentifier(nameIdentifier, it, this) } }

    private fun getIdentifierSourcePsi(): PsiElement? {
        ktClass?.nameIdentifier?.let { return it }
        (ktClass as? KtObjectDeclaration)?.getObjectKeyword()?.let { return it }
        return null
    }

    override fun getInnerClasses(): Array<UClass> {
        // filter DefaultImpls to avoid processing same methods from original interface multiple times
        // filter Enum entry classes to avoid duplication with PsiEnumConstant initializer class
        return psi.innerClasses.filter {
            it.name != JvmAbi.DEFAULT_IMPLS_CLASS_NAME && !it.isEnumEntryLightClass()
        }.mapNotNull {
            getLanguagePlugin().convertOpt<UClass>(it, this)
        }.toTypedArray()
    }

    override fun getSuperClass(): UClass? = super.getSuperClass()
    override fun getFields(): Array<UField> = super.getFields()
    override fun getInitializers(): Array<UClassInitializer> = super.getInitializers()

    override fun getMethods(): Array<UMethod> {
        val hasPrimaryConstructor = ktClass?.hasPrimaryConstructor() ?: false
        var secondaryConstructorsCount = 0

        fun createUMethod(psiMethod: PsiMethod): UMethod {
            return if (psiMethod is KtLightMethod &&
                       psiMethod.isConstructor) {
                if (!hasPrimaryConstructor && secondaryConstructorsCount++ == 0)
                    KotlinSecondaryConstructorWithInitializersUMethod(ktClass, psiMethod, this)
                else
                    KotlinConstructorUMethod(ktClass, psiMethod, this)
            } else {
                getLanguagePlugin().convertOpt(psiMethod, this) ?: reportConvertFailure(psiMethod)
            }
        }

        fun isDelegatedMethod(psiMethod: PsiMethod) = psiMethod is KtLightMethod && psiMethod.isDelegated

        val result = ArrayList<UMethod>(javaPsi.methods.size)
        val handledKtDeclarations = mutableSetOf<PsiElement>()

        for (lightMethod in javaPsi.methods) {
            if (isDelegatedMethod(lightMethod)) continue
            val uMethod = createUMethod(lightMethod)
            result.add(uMethod)

            // Ensure we pick the main Kotlin origin, not the auxiliary one
            val kotlinOrigin = (lightMethod as? KtLightMethod)?.kotlinOrigin ?: uMethod.sourcePsi
            handledKtDeclarations.addIfNotNull(kotlinOrigin)
        }

        val ktDeclarations: List<KtDeclaration> = run ktDeclarations@{
            ktClass?.let { return@ktDeclarations it.declarations }
            (javaPsi as? KtLightClassForFacade)?.let { facade ->
                return@ktDeclarations facade.files.flatMap { file -> file.declarations }
            }
            emptyList()
        }

        ktDeclarations.asSequence()
            .filterNot { handledKtDeclarations.contains(it) }
            .mapNotNullTo(result) { KotlinConverter.convertDeclaration(it, this, arrayOf(UElement::class.java)) as? UMethod }

        return result.toTypedArray()
    }

    private fun PsiClass.isEnumEntryLightClass() = (this as? KtLightClass)?.kotlinOrigin is KtEnumEntry

    companion object {
        fun create(psi: KtLightClass, containingElement: UElement?): UClass = when (psi) {
            is PsiAnonymousClass -> KotlinUAnonymousClass(psi, containingElement)
            is KtLightClassForScript -> KotlinScriptUClass(psi, containingElement)
            else -> KotlinUClass(psi, containingElement)
        }
    }

}

open class KotlinConstructorUMethod(
    private val ktClass: KtClassOrObject?,
    override val psi: PsiMethod,
    kotlinOrigin: KtDeclaration?,
    givenParent: UElement?
) : KotlinUMethod(psi, kotlinOrigin, givenParent) {

    constructor(
        ktClass: KtClassOrObject?,
        psi: KtLightMethod,
        givenParent: UElement?
    ):this(ktClass, psi, psi.kotlinOrigin, givenParent)

    val isPrimary: Boolean
        get() = sourcePsi.let { it is KtPrimaryConstructor || it is KtClassOrObject }

    override val uastBody: UExpression? by lz {
        val delegationCall: KtCallElement? = sourcePsi.let {
            when {
                isPrimary -> ktClass?.superTypeListEntries?.firstIsInstanceOrNull<KtSuperTypeCallEntry>()
                it is KtSecondaryConstructor -> it.getDelegationCall()
                else -> null
            }
        }
        val bodyExpressions = getBodyExpressions()
        if (delegationCall == null && bodyExpressions.isEmpty()) return@lz null
        KotlinUBlockExpression.KotlinLazyUBlockExpression(this) { uastParent ->
            SmartList<UExpression>().apply {
                delegationCall?.let {
                    add(KotlinUFunctionCallExpression(it, uastParent))
                }
                bodyExpressions.forEach {
                    add(KotlinConverter.convertOrEmpty(it, uastParent))
                }
            }
        }
    }

    override val uastAnchor: KotlinUIdentifier by lazy {
        KotlinUIdentifier(
            psi.nameIdentifier,
            if (isPrimary) ktClass?.nameIdentifier else (sourcePsi as? KtSecondaryConstructor)?.getConstructorKeyword(),
            this
        )
    }

    override val javaPsi = psi

    open protected fun getBodyExpressions(): List<KtExpression> {
        if (isPrimary) return getInitializers()
        val bodyExpression = (sourcePsi as? KtFunction)?.bodyExpression ?: return emptyList()
        if (bodyExpression is KtBlockExpression) return bodyExpression.statements
        return listOf(bodyExpression)
    }

    protected fun getInitializers() = ktClass?.getAnonymousInitializers()?.mapNotNull { it.body } ?: emptyList()

}

// This class was created as a workaround for KT-21617 to be the only constructor which includes `init` block
// when there is no primary constructors in the class.
// It is expected to have only one constructor of this type in a UClass.
class KotlinSecondaryConstructorWithInitializersUMethod(
        ktClass: KtClassOrObject?,
        psi: KtLightMethod,
        givenParent: UElement?
) : KotlinConstructorUMethod(ktClass, psi, givenParent) {
    override fun getBodyExpressions(): List<KtExpression> = getInitializers() + super.getBodyExpressions()
}

class KotlinUAnonymousClass(
        psi: PsiAnonymousClass,
        givenParent: UElement?
) : AbstractKotlinUClass(givenParent), UAnonymousClass, PsiAnonymousClass by psi {

    override val psi: PsiAnonymousClass = unwrap<UAnonymousClass, PsiAnonymousClass>(psi)

    override val javaPsi: PsiAnonymousClass = psi

    override val sourcePsi: KtClassOrObject? = ktClass

    override fun getOriginalElement(): PsiElement? = super<AbstractKotlinUClass>.getOriginalElement()

    override fun getSuperClass(): UClass? = super<AbstractKotlinUClass>.getSuperClass()
    override fun getFields(): Array<UField> = super<AbstractKotlinUClass>.getFields()
    override fun getMethods(): Array<UMethod> = super<AbstractKotlinUClass>.getMethods()
    override fun getInitializers(): Array<UClassInitializer> = super<AbstractKotlinUClass>.getInitializers()
    override fun getInnerClasses(): Array<UClass> = super<AbstractKotlinUClass>.getInnerClasses()

    override fun getContainingFile(): PsiFile = unwrapFakeFileForLightClass(psi.containingFile)

    override val uastAnchor by lazy {
        val ktClassOrObject = (psi.originalElement as? KtLightClass)?.kotlinOrigin as? KtObjectDeclaration ?: return@lazy null
        KotlinUIdentifier(ktClassOrObject.getObjectKeyword(), this)
        }

}

class KotlinScriptUClass(
        psi: KtLightClassForScript,
        givenParent: UElement?
) : AbstractKotlinUClass(givenParent), PsiClass by psi {
    override fun getContainingFile(): PsiFile = unwrapFakeFileForLightClass(psi.containingFile)

    override fun getNameIdentifier(): PsiIdentifier? = UastLightIdentifier(psi, psi.kotlinOrigin)

    override val uastAnchor by lazy { KotlinUIdentifier(nameIdentifier, sourcePsi?.nameIdentifier, this) }

    override val javaPsi: PsiClass = psi

    override val sourcePsi: KtClassOrObject? = psi.kotlinOrigin

    override val psi = unwrap<UClass, KtLightClassForScript>(psi)

    override fun getSuperClass(): UClass? = super.getSuperClass()

    override fun getFields(): Array<UField> = super.getFields()

    override fun getInitializers(): Array<UClassInitializer> = super.getInitializers()

    override fun getInnerClasses(): Array<UClass> =
            psi.innerClasses.mapNotNull { getLanguagePlugin().convertOpt<UClass>(it, this) }.toTypedArray()

    override fun getMethods(): Array<UMethod> = psi.methods.map(this::createUMethod).toTypedArray()

    private fun createUMethod(method: PsiMethod): UMethod {
        return if (method.isConstructor) {
            KotlinScriptConstructorUMethod(psi.script, method as KtLightMethod, this)
        }
        else {
            getLanguagePlugin().convertOpt(method, this) ?: reportConvertFailure(method)
        }
    }

    override fun getOriginalElement(): PsiElement? = psi.originalElement

    class KotlinScriptConstructorUMethod(
        script: KtScript,
        override val psi: KtLightMethod,
        givenParent: UElement?
    ) : KotlinUMethod(psi, psi.kotlinOrigin, givenParent) {
        override val uastBody: UExpression? by lz {
            val initializers = script.declarations.filterIsInstance<KtScriptInitializer>()
            KotlinUBlockExpression.create(initializers, this)
        }
        override val javaPsi = psi
    }
}

/**
 * implementation of [UClass] for invalid code, when it is impossible to create a [KtLightClass]
 */
class KotlinInvalidUClass(
    override val psi: PsiClass,
    givenParent: UElement?
) : AbstractKotlinUClass(givenParent), PsiClass by psi {

    constructor(name: String, context: PsiElement, givenParent: UElement?) : this(LightPsiClassBuilder(context, name), givenParent)

    override fun getContainingFile(): PsiFile? = uastParent?.getContainingUFile()?.sourcePsi as? PsiFile

    override val sourcePsi: PsiElement? get() = null

    override val uastAnchor: UIdentifier? get() = null

    override val javaPsi: PsiClass get() = psi

    override fun getFields(): Array<UField> = emptyArray()

    override fun getInitializers(): Array<UClassInitializer> = emptyArray()

    override fun getInnerClasses(): Array<UClass> = emptyArray()

    override fun getMethods(): Array<UMethod> = emptyArray()

    override fun getSuperClass(): UClass? = null

    override fun getOriginalElement(): PsiElement? = null
}

private fun reportConvertFailure(psiMethod: PsiMethod): Nothing {
    val isValid = psiMethod.isValid
    val report = KotlinExceptionWithAttachments(
        "cant convert $psiMethod of ${psiMethod.javaClass} to UMethod"
                + if (!isValid) " (method is not valid)" else ""
    )

    if (isValid) {
        report.withAttachment("method", psiMethod.text)
        psiMethod.containingFile?.let {
            report.withAttachment("file", it.text)
        }
    }

    throw report
}
