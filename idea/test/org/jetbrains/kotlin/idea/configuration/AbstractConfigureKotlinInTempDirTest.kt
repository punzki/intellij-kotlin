/*
 * Copyright 2010-2019 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.idea.configuration

import com.intellij.openapi.util.io.FileUtil
import org.jetbrains.kotlin.idea.artifacts.TestKotlinArtifacts
import org.jetbrains.kotlin.test.KotlinTestUtils
import org.junit.Assert
import java.io.File
import java.nio.file.Path

abstract class AbstractConfigureKotlinInTempDirTest : AbstractConfigureKotlinTest() {
    // TODO: overriding 'getProjectDirOrFile()' is not possible anymore. What else can we do here?
    /*
    override fun getProjectDirOrFile(): Path {
        val tempDir = KotlinTestUtils.tmpDirForReusableFolder("temp")

        FileUtil.copyDir(File(projectRoot), tempDir)

        val kotlinRuntime = File(tempDir, "lib/kotlin-stdlib.jar")
        if (getTestName(true).toLowerCase().contains("latestruntime") && kotlinRuntime.exists()) {
            TestKotlinArtifacts.kotlinStdlib.copyTo(kotlinRuntime, overwrite = true)
        }

        val projectRoot = tempDir.path

        val projectFilePath = projectRoot + "/projectFile.ipr"
        if (!File(projectFilePath).exists()) {
            val dotIdeaPath = projectRoot + "/.idea"
            Assert.assertTrue("Project file or '.idea' dir should exists in " + projectRoot, File(dotIdeaPath).exists())
            return File(projectRoot).toPath()
        }

        return File(projectFilePath).toPath()
    }*/
}