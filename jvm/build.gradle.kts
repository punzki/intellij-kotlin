// GENERATED build.gradle.kts
// GENERATED BY kotlin.jvm.iml
// USE `./gradlew generateIdePluginGradleFiles` TO REGENERATE THIS FILE

plugins {
    kotlin("jvm")
    `java-library` // Add `compileOnlyApi` configuration
    id("jps-compatible")
}

repositories {
    maven { setUrl("https://cache-redirector.jetbrains.com/maven-central") }
    maven { setUrl("https://cache-redirector.jetbrains.com/intellij-third-party-dependencies") }
    maven { setUrl("https://cache-redirector.jetbrains.com/jcenter") }
    maven { setUrl("https://cache-redirector.jetbrains.com/dl.google.com/dl/android/maven2") }
    maven { setUrl("https://cache-redirector.jetbrains.com/repo.jenkins-ci.org/releases") }
    maven { setUrl("https://cache-redirector.jetbrains.com/dl.bintray.com/groovy/maven/") }
    maven { setUrl("https://cache-redirector.jetbrains.com/jetbrains.bintray.com/jediterm/") }
    maven { setUrl("https://cache-redirector.jetbrains.com/jetbrains.bintray.com/markdown") }
    maven { setUrl("https://cache-redirector.jetbrains.com/www.myget.org/F/rd-snapshots/maven") }
    maven { setUrl("https://cache-redirector.jetbrains.com/download.jetbrains.com/teamcity-repository") }
    maven { setUrl("https://cache-redirector.jetbrains.com/kotlin.bintray.com/kotlin-plugin/") }
    maven { setUrl("https://cache-redirector.jetbrains.com/jetbrains.bintray.com/space") }
    maven { setUrl("https://cache-redirector.jetbrains.com/kotlin.bintray.com/kotlin-ide-plugin-dependencies") }
    maven { setUrl("https://cache-redirector.jetbrains.com/maven.pkg.jetbrains.space/kotlin/p/kotlin/kotlin-ide") }
    maven { setUrl("https://cache-redirector.jetbrains.com/kotlin.bintray.com/kotlin-ide-plugin-dependencies") }
}

disableDependencyVerification()

dependencies {
    implementation(toolsJarApi())
    jpsLikeJarDependency(kotlinStdlib(), JpsDepScope.COMPILE)
    jpsLikeJarDependency(project(":kotlin-stdlib-jdk7"), JpsDepScope.COMPILE)
    jpsLikeJarDependency("com.google.guava:guava:29.0-jre", JpsDepScope.COMPILE)
    jpsLikeJarDependency("org.swinglabs:swingx-core:1.6.2-2", JpsDepScope.COMPILE)
    jpsLikeJarDependency("org.jetbrains.intellij.deps:jdom:2.0.6", JpsDepScope.COMPILE)
    jpsLikeJarDependency("com.google.code.gson:gson:2.8.6", JpsDepScope.COMPILE)
    jpsLikeJarDependency(project(":prepare:ide-plugin-dependencies:kotlin-compiler-for-ide"), JpsDepScope.COMPILE)
    jpsLikeJarDependency(project(":kotlin-scripting-compiler"), JpsDepScope.COMPILE)
    jpsLikeJarDependency(project(":kotlin-scripting-compiler-impl"), JpsDepScope.COMPILE)
    jpsLikeModuleDependency(":kotlin-ide.kotlin.core", JpsDepScope.COMPILE)
    jpsLikeModuleDependency(":kotlin-ide.kotlin.common", JpsDepScope.COMPILE)
    jpsLikeModuleDependency(":kotlin-ide.kotlin.fir.frontend-independent", JpsDepScope.COMPILE)
    jpsLikeModuleDependency(":kotlin-ide.kotlin.jps-common", JpsDepScope.COMPILE)
    jpsLikeModuleDependency(":kotlin-ide.kotlin.jvm-debugger.core", JpsDepScope.COMPILE)
    jpsLikeModuleDependency(":kotlin-ide.kotlin.idea", JpsDepScope.COMPILE)
    jpsLikeModuleDependency(":kotlin-ide.kotlin.formatter", JpsDepScope.COMPILE)
    jpsLikeModuleDependency(":kotlin-ide.kotlin.jvm-debugger.util", JpsDepScope.COMPILE)
    jpsLikeModuleDependency(":kotlin-ide.kotlin.gradle.gradle-tooling", JpsDepScope.COMPILE)
    jpsLikeModuleDependency(":kotlin-ide.kotlin.repl", JpsDepScope.COMPILE)
    jpsLikeJarDependency(intellijPluginDep("java", forIde = true), JpsDepScope.COMPILE) // 'intellij.java.debugger.impl' dependency
    jpsLikeJarDependency(intellijDep(forIde = true), JpsDepScope.COMPILE, { includeJars("platform-api") }) // 'intellij.java.debugger.impl' dependency
    jpsLikeJarDependency(intellijDep(forIde = true), JpsDepScope.COMPILE, { includeJars("resources_en") }) // 'intellij.java.debugger.impl' dependency
    jpsLikeJarDependency(intellijDep(forIde = true), JpsDepScope.COMPILE, { includeJars("intellij-core-analysis-deprecated") }) // 'intellij.java.debugger.impl' dependency
    jpsLikeJarDependency(intellijDep(forIde = true), JpsDepScope.COMPILE, { includeJars("javac2") }) // 'intellij.java.debugger.impl' dependency
    jpsLikeJarDependency(intellijDep(forIde = true), JpsDepScope.COMPILE, { includeJars("forms_rt") }) // 'intellij.java.debugger.impl' dependency
    jpsLikeJarDependency(intellijCoreDep(), JpsDepScope.COMPILE) // 'intellij.java.debugger.impl' dependency
    jpsLikeJarDependency(intellijDep(forIde = true), JpsDepScope.COMPILE, { includeJars("extensions") }) // 'intellij.java.debugger.impl' dependency
    jpsLikeJarDependency(intellijDep(forIde = true), JpsDepScope.COMPILE, { includeJars("platform-ide-util-io") }) // 'intellij.java.debugger.impl' dependency
    jpsLikeJarDependency(intellijDep(forIde = true), JpsDepScope.COMPILE, { includeJars("resources") }) // 'intellij.java.debugger.impl' dependency
    jpsLikeJarDependency(intellijDep(forIde = true), JpsDepScope.COMPILE, { includeJars("util") }) // 'intellij.java.debugger.impl' dependency
    jpsLikeJarDependency(intellijDep(forIde = true), JpsDepScope.COMPILE, { includeJars("platform-util-ex") }) // 'intellij.java.debugger.impl' dependency
    jpsLikeJarDependency("org.jetbrains:annotations:20.1.0", JpsDepScope.COMPILE) // 'intellij.java.debugger.impl' dependency
    jpsLikeJarDependency("com.jgoodies:forms:1.1-preview", JpsDepScope.COMPILE) // 'intellij.java.debugger.impl' dependency
    jpsLikeJarDependency(intellijDep(forIde = true), JpsDepScope.COMPILE, { includeJars("external-system-rt") }) // 'intellij.platform.externalSystem' dependency
    jpsLikeJarDependency(intellijPluginDep("coverage", forIde = true), JpsDepScope.COMPILE) // 'intellij.java.coverage' dependency
    jpsLikeJarDependency(files(intellijCommunityDir.resolve("plugins/coverage/lib/coverage-report.jar").canonicalPath), JpsDepScope.COMPILE) // 'intellij.java.coverage' dependency
    jpsLikeJarDependency(files(intellijCommunityDir.resolve("plugins/coverage/lib/coverage-report-idea.jar").canonicalPath), JpsDepScope.COMPILE) // 'intellij.java.coverage' dependency
    jpsLikeJarDependency(files(intellijCommunityDir.resolve("plugins/coverage/lib/freemarker.jar").canonicalPath), JpsDepScope.COMPILE) // 'intellij.java.coverage' dependency
    jpsLikeJarDependency(intellijDep(forIde = true), JpsDepScope.COMPILE, { includeJars("coverage-common") }) // 'intellij.java.coverage' dependency
    jpsLikeJarDependency("org.jetbrains.intellij.deps:asm-all:9.0", JpsDepScope.COMPILE, { isTransitive = false }) // 'intellij.java.coverage' dependency
    jpsLikeJarDependency("org.jetbrains.intellij.deps:intellij-coverage-agent:1.0.573", JpsDepScope.COMPILE, { isTransitive = false }) // 'intellij.java.coverage' dependency
    jpsLikeJarDependency("org.jetbrains.intellij.deps:intellij-test-discovery-agent:1.0.573", JpsDepScope.COMPILE, { isTransitive = false }) // 'intellij.java.coverage' dependency
    jpsLikeJarDependency(intellijPluginDep("IntelliLang", forIde = true), JpsDepScope.COMPILE) // 'intellij.platform.langInjection' dependency
    jpsLikeJarDependency(intellijDep(forIde = true), JpsDepScope.COMPILE, { includeJars("bootstrap") }) // 'intellij.platform.boot' dependency
    jpsLikeJarDependency(intellijDep(forIde = true), JpsDepScope.COMPILE, { includeJars("testFramework") }) // 'intellij.platform.testFramework' dependency
    jpsLikeJarDependency("junit:junit:4.12", JpsDepScope.COMPILE) // 'intellij.platform.testFramework' dependency
    jpsLikeJarDependency("log4j:log4j:1.2.17", JpsDepScope.COMPILE) // 'intellij.platform.testFramework' dependency
    jpsLikeJarDependency(intellijDep(forIde = true), JpsDepScope.COMPILE, { includeJars("idea_rt") }) // 'intellij.platform.testFramework' dependency
    jpsLikeJarDependency(intellijDep(forIde = true), JpsDepScope.COMPILE, { includeJars("platform-core-ui") }) // 'intellij.platform.testFramework' dependency
    jpsLikeJarDependency(intellijDep(forIde = true), JpsDepScope.COMPILE, { includeJars("platform-impl") }) // 'intellij.platform.testFramework' dependency
    jpsLikeJarDependency("org.apache.velocity:velocity:1.7", JpsDepScope.COMPILE) // 'intellij.platform.testFramework' dependency
    jpsLikeJarDependency(intellijDep(forIde = true), JpsDepScope.COMPILE, { includeJars("platform-concurrency") }) // 'intellij.platform.testFramework' dependency
    jpsLikeJarDependency(intellijDep(forIde = true), JpsDepScope.COMPILE, { includeJars("jps-model") }) // 'intellij.platform.testFramework' dependency
    jpsLikeJarDependency(intellijDep(forIde = true), JpsDepScope.COMPILE, { includeJars("testFramework.core") }) // 'intellij.platform.testFramework' dependency
    jpsLikeJarDependency(intellijDep(forIde = true), JpsDepScope.COMPILE, { includeJars("platform-util-ui") }) // 'intellij.platform.testFramework' dependency
    jpsLikeJarDependency("org.jetbrains:jetCheck:0.2.2", JpsDepScope.COMPILE, { isTransitive = false }) // 'intellij.platform.testFramework' dependency
    jpsLikeJarDependency("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.4.0", JpsDepScope.COMPILE) // 'intellij.platform.testFramework' dependency
    jpsLikeJarDependency("org.codehaus.groovy:groovy:2.5.11", JpsDepScope.COMPILE) // 'intellij.platform.testFramework' dependency
    jpsLikeJarDependency(intellijDep(forIde = true), JpsDepScope.COMPILE, { includeJars("intellij-dvcs") }) // 'intellij.platform.vcs.impl' dependency
    jpsLikeJarDependency(intellijPluginDep("java-decompiler", forIde = true), JpsDepScope.COMPILE) // 'intellij.java.decompiler.engine' dependency
    jpsLikeJarDependency(intellijDep(forIde = true), JpsDepScope.COMPILE, { includeJars("platform-statistics") }) // 'intellij.java.execution.impl' dependency
    jpsLikeJarDependency(intellijDep(forIde = true), JpsDepScope.COMPILE, { includeJars("platform-statistics-uploader") }) // 'intellij.java.execution.impl' dependency
    jpsLikeJarDependency(intellijDep(forIde = true), JpsDepScope.COMPILE, { includeJars("platform-statistics-config") }) // 'intellij.java.execution.impl' dependency
    jpsLikeJarDependency(intellijPluginDep("java-i18n", forIde = true), JpsDepScope.COMPILE) // 'intellij.java.i18n' dependency
    jpsLikeJarDependency(intellijPluginDep("properties", forIde = true), JpsDepScope.COMPILE) // 'intellij.java.i18n' dependency
    jpsLikeJarDependency(intellijPluginDep("junit", forIde = true), JpsDepScope.COMPILE) // 'intellij.junit' dependency
    jpsLikeJarDependency("org.jetbrains.teamcity:serviceMessages:2019.1.4", JpsDepScope.COMPILE, { isTransitive = false }) // 'intellij.junit' dependency
    jpsLikeJarDependency(intellijPluginDep("testng", forIde = true), JpsDepScope.COMPILE) // 'intellij.testng' dependency
    jpsLikeJarDependency(intellijDep(forIde = true), JpsDepScope.COMPILE, { includeJars("intellij-xml") }) // 'intellij.xml.psi.impl' dependency
}

configurations.all {
    exclude(module = "tests-common") // Avoid classes with same FQN clashing
}

sourceSets {
    "main" {
        java.srcDir("src")
        resources.srcDir("resources")
    }
    "test" {
        
    }
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(11))
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.dsl.KotlinJvmCompile> {
    kotlinOptions.freeCompilerArgs = listOf("-version", "-Xstrict-java-nullability-assertions", "-Xjvm-default=enable", "-Xskip-prerelease-check")
    kotlinOptions.jdkHome = rootProject.extra["JDK_11"] as String
    kotlinOptions.useOldBackend = true // KT-45697
}

// Fake empty configuration in order to make `DependencyHandler.projectTests(name: String)` work
configurations.getOrCreate("tests-jar")