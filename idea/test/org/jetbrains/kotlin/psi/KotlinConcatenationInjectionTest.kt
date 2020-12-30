package org.jetbrains.kotlin.psi

import com.intellij.lang.Language
import com.intellij.lang.html.HTMLLanguage
import com.intellij.psi.injection.Injectable
import org.intellij.plugins.intelliLang.inject.InjectLanguageAction
import org.junit.internal.runners.JUnit38ClassRunner
import org.junit.runner.RunWith

@RunWith(JUnit38ClassRunner::class)
class KotlinConcatenationInjectionTest : AbstractInjectionTest() {

    fun testConcatenationInjectionWithAnnotation() = doInjectionPresentTest(
        """
            fun bar(a: Int) { Test.foo("<caret>some" + a + "bar" + "foo") }
            """,
        javaText =
        """
            import org.intellij.lang.annotations.Language;

            public class Test {
                public static void foo(@Language("HTML") String str) {}
            }
            """,
        languageId = HTMLLanguage.INSTANCE.id,
        unInjectShouldBePresent = false,
        shreds = listOf(
            ShredInfo(range(0, 4), range(1, 5), prefix = "", suffix = ""),
            ShredInfo(range(4, 8), range(1, 4), prefix = "a", suffix = ""),
            ShredInfo(range(8, 11), range(1, 4), prefix = "", suffix = "")
        ),
        injectedText = "someabarfoo"
    )

    fun testComplexInterpolationConcantenationInjection() = doInjectionPresentTest(
        """
            fun bar(a: Int) { Test.foo(1 + "${'$'}{s} <caret>text" + " ${'$'}{s}${'$'}s${'$'}{s} " + s + " text ${'$'}{s}") }
            """,
        javaText =
        """
            import org.intellij.lang.annotations.Language;

            public class Test {
                public static void foo(@Language("HTML") String str) {}
            }
            """,
        languageId = HTMLLanguage.INSTANCE.id,
        unInjectShouldBePresent = false,
        shreds = listOf(
            ShredInfo(range(0, 1), range(1, 1), prefix = "1", suffix = ""),
            ShredInfo(range(1, 18), range(5, 10), prefix = "missingValue", suffix = ""),
            ShredInfo(range(18, 19), range(1, 2), prefix = "", suffix = ""),
            ShredInfo(range(19, 31), range(6, 6), prefix = "missingValue", suffix = ""),
            ShredInfo(range(31, 32), range(8, 8), prefix = "s", suffix = ""),
            ShredInfo(range(32, 45), range(12, 13), prefix = "missingValue", suffix = ""),
            ShredInfo(range(45, 52), range(1, 7), prefix = "s", suffix = ""),
            ShredInfo(range(52, 64), range(11, 11), prefix = "missingValue", suffix = "")
        ),
        injectedText = "1missingValue text missingValuesmissingValue s text missingValue"
    )

    fun testTempInjection(){
        myFixture.configureByText("${getTestName(true)}.kt", """
            fun bar(){ val reg = "\\d<caret>\\d" + "\\w\\w" }
        """.trimIndent())

        InjectLanguageAction.invokeImpl(project, editor, file, Injectable.fromLanguage(Language.findLanguageByID("RegExp")))

        myInjectionFixture.assertInjectedLangAtCaret("RegExp")
        val files = myInjectionFixture.getAllInjections().mapTo(mutableSetOf()) { it.second }.map { it.text }

        assertSameElements(files, "\\\\d\\\\d\\\\w\\\\w")
    }

}