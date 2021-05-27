/*
 * Copyright 2010-2021 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.uast.kotlin

import com.intellij.psi.PsiElement
import com.intellij.psi.PsiType
import org.jetbrains.kotlin.idea.frontend.api.analyseWithCustomToken
import org.jetbrains.kotlin.idea.frontend.api.tokens.AlwaysAccessibleValidityTokenFactory
import org.jetbrains.kotlin.idea.references.mainReference
import org.jetbrains.kotlin.load.kotlin.TypeMappingMode
import org.jetbrains.kotlin.psi.KtExpression
import org.jetbrains.kotlin.psi.KtReferenceExpression
import org.jetbrains.uast.UElement
import org.jetbrains.uast.UExpression

interface FirKotlinUastResolveProviderService : BaseKotlinUastResolveProviderService {
    override val baseKotlinConverter: BaseKotlinConverter
        get() = FirKotlinConverter

    override fun convertParent(uElement: UElement): UElement? {
        TODO("Not yet implemented")
    }

    override fun resolveToDeclaration(ktExpression: KtExpression): PsiElement? {
        when (ktExpression) {
            is KtReferenceExpression -> {
                analyseWithCustomToken(ktExpression, AlwaysAccessibleValidityTokenFactory) {
                    return ktExpression.mainReference.resolve()
                }
            }
            else ->
                return null
        }
    }

    override fun getExpressionType(uExpression: UExpression): PsiType? {
        val ktExpression = uExpression.sourcePsi as? KtExpression ?: return null
        analyseWithCustomToken(ktExpression, AlwaysAccessibleValidityTokenFactory) {
            return ktExpression.getPsiType(TypeMappingMode.DEFAULT_UAST)
        }
    }

    override fun evaluate(uExpression: UExpression): Any? {
        // TODO("Not yet implemented")
        return "not-yet-compile-time-constant"
    }
}
