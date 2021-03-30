/*
 * Copyright 2010-2021 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.idea.perf;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.JUnit3RunnerWithInners;
import org.jetbrains.kotlin.test.KotlinTestUtils;
import org.jetbrains.kotlin.test.TestMetadata;
import org.jetbrains.kotlin.test.TestRoot;
import org.junit.runner.RunWith;

/*
 * This class is generated by {@link org.jetbrains.kotlin.generators.tests.TestsPackage}.
 * DO NOT MODIFY MANUALLY.
 */
@SuppressWarnings("all")
@TestRoot("performance-tests")
@TestDataPath("$CONTENT_ROOT")
@RunWith(JUnit3RunnerWithInners.class)
@TestMetadata("../completion/tests/testData/handlers/charFilter")
public class PerformanceCompletionCharFilterTestGenerated extends AbstractPerformanceCompletionCharFilterTest {
    private void runTest(String testDataFilePath) throws Exception {
        KotlinTestUtils.runTest(this::doPerfTest, this, testDataFilePath);
    }

    @TestMetadata("Colon.kt")
    public void testColon() throws Exception {
        runTest("../completion/tests/testData/handlers/charFilter/Colon.kt");
    }

    @TestMetadata("Comma1.kt")
    public void testComma1() throws Exception {
        runTest("../completion/tests/testData/handlers/charFilter/Comma1.kt");
    }

    @TestMetadata("Comma2.kt")
    public void testComma2() throws Exception {
        runTest("../completion/tests/testData/handlers/charFilter/Comma2.kt");
    }

    @TestMetadata("Comma3.kt")
    public void testComma3() throws Exception {
        runTest("../completion/tests/testData/handlers/charFilter/Comma3.kt");
    }

    @TestMetadata("Comma4.kt")
    public void testComma4() throws Exception {
        runTest("../completion/tests/testData/handlers/charFilter/Comma4.kt");
    }

    @TestMetadata("Comma5.kt")
    public void testComma5() throws Exception {
        runTest("../completion/tests/testData/handlers/charFilter/Comma5.kt");
    }

    @TestMetadata("CommaForFunction1.kt")
    public void testCommaForFunction1() throws Exception {
        runTest("../completion/tests/testData/handlers/charFilter/CommaForFunction1.kt");
    }

    @TestMetadata("CommaForFunction2.kt")
    public void testCommaForFunction2() throws Exception {
        runTest("../completion/tests/testData/handlers/charFilter/CommaForFunction2.kt");
    }

    @TestMetadata("ConstructorWithLambdaArg1.kt")
    public void testConstructorWithLambdaArg1() throws Exception {
        runTest("../completion/tests/testData/handlers/charFilter/ConstructorWithLambdaArg1.kt");
    }

    @TestMetadata("ConstructorWithLambdaArg2.kt")
    public void testConstructorWithLambdaArg2() throws Exception {
        runTest("../completion/tests/testData/handlers/charFilter/ConstructorWithLambdaArg2.kt");
    }

    @TestMetadata("Dot.kt")
    public void testDot() throws Exception {
        runTest("../completion/tests/testData/handlers/charFilter/Dot.kt");
    }

    @TestMetadata("DotAfterFun1.kt")
    public void testDotAfterFun1() throws Exception {
        runTest("../completion/tests/testData/handlers/charFilter/DotAfterFun1.kt");
    }

    @TestMetadata("DotAfterFun2.kt")
    public void testDotAfterFun2() throws Exception {
        runTest("../completion/tests/testData/handlers/charFilter/DotAfterFun2.kt");
    }

    @TestMetadata("Eq1.kt")
    public void testEq1() throws Exception {
        runTest("../completion/tests/testData/handlers/charFilter/Eq1.kt");
    }

    @TestMetadata("Eq2.kt")
    public void testEq2() throws Exception {
        runTest("../completion/tests/testData/handlers/charFilter/Eq2.kt");
    }

    @TestMetadata("FunctionLiteralParameter1.kt")
    public void testFunctionLiteralParameter1() throws Exception {
        runTest("../completion/tests/testData/handlers/charFilter/FunctionLiteralParameter1.kt");
    }

    @TestMetadata("FunctionLiteralParameter2.kt")
    public void testFunctionLiteralParameter2() throws Exception {
        runTest("../completion/tests/testData/handlers/charFilter/FunctionLiteralParameter2.kt");
    }

    @TestMetadata("FunctionLiteralParameter3.kt")
    public void testFunctionLiteralParameter3() throws Exception {
        runTest("../completion/tests/testData/handlers/charFilter/FunctionLiteralParameter3.kt");
    }

    @TestMetadata("FunctionWithLambdaArg1.kt")
    public void testFunctionWithLambdaArg1() throws Exception {
        runTest("../completion/tests/testData/handlers/charFilter/FunctionWithLambdaArg1.kt");
    }

    @TestMetadata("FunctionWithLambdaArg2.kt")
    public void testFunctionWithLambdaArg2() throws Exception {
        runTest("../completion/tests/testData/handlers/charFilter/FunctionWithLambdaArg2.kt");
    }

    @TestMetadata("InfixCallAndSpace.kt")
    public void testInfixCallAndSpace() throws Exception {
        runTest("../completion/tests/testData/handlers/charFilter/InfixCallAndSpace.kt");
    }

    @TestMetadata("KeywordAndSpace.kt")
    public void testKeywordAndSpace() throws Exception {
        runTest("../completion/tests/testData/handlers/charFilter/KeywordAndSpace.kt");
    }

    @TestMetadata("LParenth.kt")
    public void testLParenth() throws Exception {
        runTest("../completion/tests/testData/handlers/charFilter/LParenth.kt");
    }

    @TestMetadata("MessageBundle1.kt")
    public void testMessageBundle1() throws Exception {
        runTest("../completion/tests/testData/handlers/charFilter/MessageBundle1.kt");
    }

    @TestMetadata("NamedParameter1.kt")
    public void testNamedParameter1() throws Exception {
        runTest("../completion/tests/testData/handlers/charFilter/NamedParameter1.kt");
    }

    @TestMetadata("NamedParameter2.kt")
    public void testNamedParameter2() throws Exception {
        runTest("../completion/tests/testData/handlers/charFilter/NamedParameter2.kt");
    }

    @TestMetadata("QualifiedThis.kt")
    public void testQualifiedThis() throws Exception {
        runTest("../completion/tests/testData/handlers/charFilter/QualifiedThis.kt");
    }

    @TestMetadata("RangeTyping.kt")
    public void testRangeTyping() throws Exception {
        runTest("../completion/tests/testData/handlers/charFilter/RangeTyping.kt");
    }

    @TestMetadata("Space.kt")
    public void testSpace() throws Exception {
        runTest("../completion/tests/testData/handlers/charFilter/Space.kt");
    }

    @TestMetadata("VariableName.kt")
    public void testVariableName() throws Exception {
        runTest("../completion/tests/testData/handlers/charFilter/VariableName.kt");
    }

    @TestMetadata("VariableName2.kt")
    public void testVariableName2() throws Exception {
        runTest("../completion/tests/testData/handlers/charFilter/VariableName2.kt");
    }

    @TestMetadata("VariableName3.kt")
    public void testVariableName3() throws Exception {
        runTest("../completion/tests/testData/handlers/charFilter/VariableName3.kt");
    }
}
