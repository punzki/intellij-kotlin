/*
 * Copyright 2010-2021 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.uast.test.kotlin

import org.jetbrains.uast.test.common.kotlin.FirLegacyUastTypesTestBase

abstract class AbstractFirLegacyUastTypesTest : AbstractFirUastTypesTest(), FirLegacyUastTypesTestBase {
    private val whitelist : Set<String> = setOf(
        // TODO: not able to map Stream<String?..String>
        "plugins/uast-kotlin/testData/Lambdas.kt",
    )
    override fun isExpectedToFail(filePath: String): Boolean {
        return filePath in whitelist
    }
}
