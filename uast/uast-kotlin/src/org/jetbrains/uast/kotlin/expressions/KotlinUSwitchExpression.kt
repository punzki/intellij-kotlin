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

import com.intellij.psi.PsiElement
import org.jetbrains.kotlin.psi.KtBlockExpression
import org.jetbrains.kotlin.psi.KtExpression
import org.jetbrains.kotlin.psi.KtWhenEntry
import org.jetbrains.kotlin.psi.KtWhenExpression
import org.jetbrains.kotlin.utils.addToStdlib.safeAs
import org.jetbrains.uast.*
import org.jetbrains.uast.kotlin.kinds.KotlinSpecialExpressionKinds

class KotlinUSwitchExpression(
        override val sourcePsi: KtWhenExpression,
        givenParent: UElement?
) : KotlinAbstractUExpression(givenParent), USwitchExpression, KotlinUElementWithType {
    override val expression by lz { KotlinConverter.convertOrNull(sourcePsi.subjectExpression, this) }

    override val body: UExpressionList by lz {
        object : KotlinUExpressionList(
            sourcePsi,
            KotlinSpecialExpressionKinds.WHEN,
            this@KotlinUSwitchExpression,
            baseResolveProviderService
        ) {
            override fun asRenderString() = expressions.joinToString("\n") { it.asRenderString().withMargin }
        }.apply {
            expressions = this@KotlinUSwitchExpression.sourcePsi.entries.map { KotlinUSwitchEntry(it, this) }
        }
    }

    override fun asRenderString() = buildString {
        val expr = expression?.let { "(" + it.asRenderString() + ") " } ?: ""
        appendLine("switch $expr {")
        appendLine(body.asRenderString())
        appendLine("}")
    }

    override val switchIdentifier: UIdentifier
        get() = KotlinUIdentifier(null, this)
}

class KotlinUSwitchEntry(
        override val sourcePsi: KtWhenEntry,
        givenParent: UElement?
) : KotlinAbstractUExpression(givenParent), USwitchClauseExpressionWithBody {
    override val caseValues by lz {
        sourcePsi.conditions.map { KotlinConverter.convertWhenCondition(it, this, DEFAULT_EXPRESSION_TYPES_LIST) ?: UastEmptyExpression(null) }
    }

    override val body: UExpressionList by lz {
        object : KotlinUExpressionList(
            sourcePsi,
            KotlinSpecialExpressionKinds.WHEN_ENTRY,
            this@KotlinUSwitchEntry,
            baseResolveProviderService
        ) {
            override fun asRenderString() = buildString {
                appendLine("{")
                expressions.forEach { appendLine(it.asRenderString().withMargin) }
                appendLine("}")
            }
        }.apply KotlinUExpressionList@{
            val exprPsi = this@KotlinUSwitchEntry.sourcePsi.expression
            val userExpressions = when (exprPsi) {
                is KtBlockExpression -> exprPsi.statements.map { KotlinConverter.convertOrEmpty(it, this) }
                else -> listOf(KotlinConverter.convertOrEmpty(exprPsi, this))
            }
            expressions =
                if (userExpressions.isNotEmpty())
                    userExpressions.subList(0, userExpressions.lastIndex) + object : UYieldExpression {
                        override val javaPsi: PsiElement? = null
                        override val sourcePsi: PsiElement? = null
                        override val psi: PsiElement?
                            get() = null
                        override val label: String?
                            get() = null
                        override val uastParent: UElement?
                            get() = this@KotlinUExpressionList
                        override val annotations: List<UAnnotation>
                            get() = emptyList()
                        override val expression: UExpression?
                            get() = userExpressions.lastOrNull()?.sourcePsi?.let { it.safeAs<KtExpression>() ?: it.parent.safeAs() }
                                ?.let { KotlinConverter.convertExpression(it, this, DEFAULT_EXPRESSION_TYPES_LIST) }
                    }
                else emptyList()
        }
    }

    override fun convertParent(): UElement? {
        val result = KotlinConverter.unwrapElements(sourcePsi.parent)?.let { parentUnwrapped ->
            KotlinUastLanguagePlugin().convertElementWithParent(parentUnwrapped, null)
        }
        return (result as? KotlinUSwitchExpression)?.body ?: result
    }
}
