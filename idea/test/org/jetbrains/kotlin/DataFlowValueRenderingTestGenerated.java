/*
 * Copyright 2010-2021 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin;

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
@TestRoot("idea")
@TestDataPath("$CONTENT_ROOT")
@RunWith(JUnit3RunnerWithInners.class)
@TestMetadata("testData/dataFlowValueRendering")
public class DataFlowValueRenderingTestGenerated extends AbstractDataFlowValueRenderingTest {
    private void runTest(String testDataFilePath) throws Exception {
        KotlinTestUtils.runTest(this::doTest, this, testDataFilePath);
    }

    @TestMetadata("classProperty.kt")
    public void testClassProperty() throws Exception {
        runTest("testData/dataFlowValueRendering/classProperty.kt");
    }

    @TestMetadata("complexIdentifier.kt")
    public void testComplexIdentifier() throws Exception {
        runTest("testData/dataFlowValueRendering/complexIdentifier.kt");
    }

    @TestMetadata("complexIdentifierWithImplicitReceiver.kt")
    public void testComplexIdentifierWithImplicitReceiver() throws Exception {
        runTest("testData/dataFlowValueRendering/complexIdentifierWithImplicitReceiver.kt");
    }

    @TestMetadata("complexIdentifierWithInitiallyNullableReceiver.kt")
    public void testComplexIdentifierWithInitiallyNullableReceiver() throws Exception {
        runTest("testData/dataFlowValueRendering/complexIdentifierWithInitiallyNullableReceiver.kt");
    }

    @TestMetadata("complexIdentifierWithReceiver.kt")
    public void testComplexIdentifierWithReceiver() throws Exception {
        runTest("testData/dataFlowValueRendering/complexIdentifierWithReceiver.kt");
    }

    @TestMetadata("multipleVariables.kt")
    public void testMultipleVariables() throws Exception {
        runTest("testData/dataFlowValueRendering/multipleVariables.kt");
    }

    @TestMetadata("packageProperty.kt")
    public void testPackageProperty() throws Exception {
        runTest("testData/dataFlowValueRendering/packageProperty.kt");
    }

    @TestMetadata("receivers.kt")
    public void testReceivers() throws Exception {
        runTest("testData/dataFlowValueRendering/receivers.kt");
    }

    @TestMetadata("smartCast.kt")
    public void testSmartCast() throws Exception {
        runTest("testData/dataFlowValueRendering/smartCast.kt");
    }

    @TestMetadata("smartNotNull.kt")
    public void testSmartNotNull() throws Exception {
        runTest("testData/dataFlowValueRendering/smartNotNull.kt");
    }
}
