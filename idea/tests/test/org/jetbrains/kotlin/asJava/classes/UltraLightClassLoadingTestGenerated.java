/*
 * Copyright 2010-2021 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.asJava.classes;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.idea.test.JUnit3RunnerWithInners;
import org.jetbrains.kotlin.idea.test.KotlinTestUtils;
import org.jetbrains.kotlin.test.TestMetadata;
import org.jetbrains.kotlin.idea.test.TestRoot;
import org.junit.runner.RunWith;
import static org.jetbrains.kotlin.idea.artifacts.AdditionalKotlinArtifacts.compilerTestData;

/*
 * This class is generated by {@link org.jetbrains.kotlin.generators.tests.TestsPackage}.
 * DO NOT MODIFY MANUALLY.
 */
@SuppressWarnings("all")
@TestRoot("idea/tests")
@TestDataPath("$CONTENT_ROOT")
@RunWith(JUnit3RunnerWithInners.class)
@TestMetadata("../../../intellij/out/kotlinc-testdata/testData/compiler/testData/asJava/ultraLightClasses")
public class UltraLightClassLoadingTestGenerated extends AbstractUltraLightClassLoadingTest {
    private void runTest(String testDataFilePath) throws Exception {
        KotlinTestUtils.runTest(this::doTest, this, testDataFilePath);
    }

    @Override
    protected void setUp() {
        compilerTestData("compiler/testData/asJava/ultraLightClasses");
        super.setUp();
    }

    @TestMetadata("annotationTargets_1_6.kt")
    public void testAnnotationTargets_1_6() throws Exception {
        runTest(compilerTestData("compiler/testData/asJava/ultraLightClasses/annotationTargets_1_6.kt"));
    }

    @TestMetadata("annotationWithSetParamPropertyModifier.kt")
    public void testAnnotationWithSetParamPropertyModifier() throws Exception {
        runTest(compilerTestData("compiler/testData/asJava/ultraLightClasses/annotationWithSetParamPropertyModifier.kt"));
    }

    @TestMetadata("annotations.kt")
    public void testAnnotations() throws Exception {
        runTest(compilerTestData("compiler/testData/asJava/ultraLightClasses/annotations.kt"));
    }

    @TestMetadata("classModifiers.kt")
    public void testClassModifiers() throws Exception {
        runTest(compilerTestData("compiler/testData/asJava/ultraLightClasses/classModifiers.kt"));
    }

    @TestMetadata("constructors.kt")
    public void testConstructors() throws Exception {
        runTest(compilerTestData("compiler/testData/asJava/ultraLightClasses/constructors.kt"));
    }

    @TestMetadata("coroutines.kt")
    public void testCoroutines() throws Exception {
        runTest(compilerTestData("compiler/testData/asJava/ultraLightClasses/coroutines.kt"));
    }

    @TestMetadata("dataClasses.kt")
    public void testDataClasses() throws Exception {
        runTest(compilerTestData("compiler/testData/asJava/ultraLightClasses/dataClasses.kt"));
    }

    @TestMetadata("defaultMethodInKotlinWithSettingAll.kt")
    public void testDefaultMethodInKotlinWithSettingAll() throws Exception {
        runTest(compilerTestData("compiler/testData/asJava/ultraLightClasses/defaultMethodInKotlinWithSettingAll.kt"));
    }

    @TestMetadata("defaultMethodInKotlinWithSettingAllCompatibility.kt")
    public void testDefaultMethodInKotlinWithSettingAllCompatibility() throws Exception {
        runTest(compilerTestData("compiler/testData/asJava/ultraLightClasses/defaultMethodInKotlinWithSettingAllCompatibility.kt"));
    }

    @TestMetadata("delegatesWithAnnotations.kt")
    public void testDelegatesWithAnnotations() throws Exception {
        runTest(compilerTestData("compiler/testData/asJava/ultraLightClasses/delegatesWithAnnotations.kt"));
    }

    @TestMetadata("delegatingToInterfaces.kt")
    public void testDelegatingToInterfaces() throws Exception {
        runTest(compilerTestData("compiler/testData/asJava/ultraLightClasses/delegatingToInterfaces.kt"));
    }

    @TestMetadata("dollarsInNameLocal.kt")
    public void testDollarsInNameLocal() throws Exception {
        runTest(compilerTestData("compiler/testData/asJava/ultraLightClasses/dollarsInNameLocal.kt"));
    }

    @TestMetadata("enums.kt")
    public void testEnums() throws Exception {
        runTest(compilerTestData("compiler/testData/asJava/ultraLightClasses/enums.kt"));
    }

    @TestMetadata("generics.kt")
    public void testGenerics() throws Exception {
        runTest(compilerTestData("compiler/testData/asJava/ultraLightClasses/generics.kt"));
    }

    @TestMetadata("implementingKotlinCollections.kt")
    public void testImplementingKotlinCollections() throws Exception {
        runTest(compilerTestData("compiler/testData/asJava/ultraLightClasses/implementingKotlinCollections.kt"));
    }

    @TestMetadata("importAliases.kt")
    public void testImportAliases() throws Exception {
        runTest(compilerTestData("compiler/testData/asJava/ultraLightClasses/importAliases.kt"));
    }

    @TestMetadata("inferringAnonymousObjectTypes.kt")
    public void testInferringAnonymousObjectTypes() throws Exception {
        runTest(compilerTestData("compiler/testData/asJava/ultraLightClasses/inferringAnonymousObjectTypes.kt"));
    }

    @TestMetadata("inheritance.kt")
    public void testInheritance() throws Exception {
        runTest(compilerTestData("compiler/testData/asJava/ultraLightClasses/inheritance.kt"));
    }

    @TestMetadata("inlineClasses.kt")
    public void testInlineClasses() throws Exception {
        runTest(compilerTestData("compiler/testData/asJava/ultraLightClasses/inlineClasses.kt"));
    }

    @TestMetadata("inlineOnly.kt")
    public void testInlineOnly() throws Exception {
        runTest(compilerTestData("compiler/testData/asJava/ultraLightClasses/inlineOnly.kt"));
    }

    @TestMetadata("inlineReified.kt")
    public void testInlineReified() throws Exception {
        runTest(compilerTestData("compiler/testData/asJava/ultraLightClasses/inlineReified.kt"));
    }

    @TestMetadata("jvmField.kt")
    public void testJvmField() throws Exception {
        runTest(compilerTestData("compiler/testData/asJava/ultraLightClasses/jvmField.kt"));
    }

    @TestMetadata("jvmName.kt")
    public void testJvmName() throws Exception {
        runTest(compilerTestData("compiler/testData/asJava/ultraLightClasses/jvmName.kt"));
    }

    @TestMetadata("jvmOverloads.kt")
    public void testJvmOverloads() throws Exception {
        runTest(compilerTestData("compiler/testData/asJava/ultraLightClasses/jvmOverloads.kt"));
    }

    @TestMetadata("jvmRecord.kt")
    public void testJvmRecord() throws Exception {
        runTest(compilerTestData("compiler/testData/asJava/ultraLightClasses/jvmRecord.kt"));
    }

    @TestMetadata("jvmSynthetic.kt")
    public void testJvmSynthetic() throws Exception {
        runTest(compilerTestData("compiler/testData/asJava/ultraLightClasses/jvmSynthetic.kt"));
    }

    @TestMetadata("jvmSyntheticForAccessors.kt")
    public void testJvmSyntheticForAccessors() throws Exception {
        runTest(compilerTestData("compiler/testData/asJava/ultraLightClasses/jvmSyntheticForAccessors.kt"));
    }

    @TestMetadata("jvmWildcardAnnotations.kt")
    public void testJvmWildcardAnnotations() throws Exception {
        runTest(compilerTestData("compiler/testData/asJava/ultraLightClasses/jvmWildcardAnnotations.kt"));
    }

    @TestMetadata("lateinitProperty.kt")
    public void testLateinitProperty() throws Exception {
        runTest(compilerTestData("compiler/testData/asJava/ultraLightClasses/lateinitProperty.kt"));
    }

    @TestMetadata("localClassDerived.kt")
    public void testLocalClassDerived() throws Exception {
        runTest(compilerTestData("compiler/testData/asJava/ultraLightClasses/localClassDerived.kt"));
    }

    @TestMetadata("objects.kt")
    public void testObjects() throws Exception {
        runTest(compilerTestData("compiler/testData/asJava/ultraLightClasses/objects.kt"));
    }

    @TestMetadata("properties.kt")
    public void testProperties() throws Exception {
        runTest(compilerTestData("compiler/testData/asJava/ultraLightClasses/properties.kt"));
    }

    @TestMetadata("simpleFunctions.kt")
    public void testSimpleFunctions() throws Exception {
        runTest(compilerTestData("compiler/testData/asJava/ultraLightClasses/simpleFunctions.kt"));
    }

    @TestMetadata("throwsAnnotation.kt")
    public void testThrowsAnnotation() throws Exception {
        runTest(compilerTestData("compiler/testData/asJava/ultraLightClasses/throwsAnnotation.kt"));
    }

    @TestMetadata("typeAliases.kt")
    public void testTypeAliases() throws Exception {
        runTest(compilerTestData("compiler/testData/asJava/ultraLightClasses/typeAliases.kt"));
    }

    @TestMetadata("typeAnnotations.kt")
    public void testTypeAnnotations() throws Exception {
        runTest(compilerTestData("compiler/testData/asJava/ultraLightClasses/typeAnnotations.kt"));
    }

    @TestMetadata("wildcardOptimization.kt")
    public void testWildcardOptimization() throws Exception {
        runTest(compilerTestData("compiler/testData/asJava/ultraLightClasses/wildcardOptimization.kt"));
    }
}
