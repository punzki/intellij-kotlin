// GENERATED build.gradle.kts
// GENERATED BY kotlin.fir.fir-low-level-api.iml
// USE `./gradlew generateIdeaGradleFiles` TO REGENERATE THIS FILE

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
    maven { setUrl("https://cache-redirector.jetbrains.com/jetbrains.bintray.com/markdown") }
    maven { setUrl("https://cache-redirector.jetbrains.com/www.myget.org/F/rd-snapshots/maven") }
    maven { setUrl("https://cache-redirector.jetbrains.com/download.jetbrains.com/teamcity-repository") }
    maven { setUrl("https://cache-redirector.jetbrains.com/kotlin.bintray.com/kotlin-plugin/") }
    maven { setUrl("https://cache-redirector.jetbrains.com/jetbrains.bintray.com/space") }
    maven { setUrl("https://cache-redirector.jetbrains.com/kotlin.bintray.com/kotlin-ide-plugin-dependencies") }
}

dependencies {
    implementation(toolsJarApi())
    runtimeOnly(intellijDep(forIde = true))
    testRuntimeOnly(intellijDep(forIde = true))
    jpsLikeJarDependency(kotlinStdlib(), JpsDepScope.COMPILE)
    jpsLikeJarDependency(project(":kotlin-stdlib-jdk7"), JpsDepScope.COMPILE)
    jpsLikeJarDependency(project(":prepare:ide-plugin-dependencies:kotlin-compiler-for-ide"), JpsDepScope.COMPILE)
    jpsLikeJarDependency(project(":prepare:ide-plugin-dependencies:kotlin-compiler-tests-for-ide"), JpsDepScope.COMPILE)
    jpsLikeJarDependency(project(":prepare:ide-plugin-dependencies:kotlin-compiler-cli-for-ide"), JpsDepScope.TEST)
    jpsLikeJarDependency("com.google.code.gson:gson:2.8.6", JpsDepScope.TEST)
    jpsLikeJarDependency("org.opentest4j:opentest4j:1.2.0", JpsDepScope.COMPILE)
    jpsLikeModuleDependency(":kotlin-ide.kotlin.fir.frontend-api", JpsDepScope.COMPILE)
    jpsLikeModuleDependency(":kotlin-ide.kotlin.tests-common", JpsDepScope.TEST)
    jpsLikeModuleDependency(":kotlin-ide.kotlin.test-framework", JpsDepScope.TEST)
    jpsLikeModuleDependency(":kotlin-ide.kotlin.idea.tests", JpsDepScope.TEST)
    jpsLikeJarDependency(intellijDep(forIde = true), JpsDepScope.COMPILE, { includeJars("platform-impl") }) // 'intellij.platform.core.impl' dependency
    jpsLikeJarDependency(intellijDep(forIde = true), JpsDepScope.COMPILE, { includeJars("resources_en") }) // 'intellij.platform.core.impl' dependency
    jpsLikeJarDependency(intellijCoreDep(), JpsDepScope.COMPILE) // 'intellij.platform.core.impl' dependency
    jpsLikeJarDependency(intellijDep(forIde = true), JpsDepScope.COMPILE, { includeJars("intellij-core-analysis-deprecated") }) // 'intellij.platform.core.impl' dependency
    jpsLikeJarDependency(intellijDep(forIde = true), JpsDepScope.COMPILE, { includeJars("platform-api") }) // 'intellij.platform.core.impl' dependency
    jpsLikeJarDependency(intellijDep(forIde = true), JpsDepScope.COMPILE, { includeJars("extensions") }) // 'intellij.platform.core.impl' dependency
    jpsLikeJarDependency(intellijDep(forIde = true), JpsDepScope.COMPILE, { includeJars("util") }) // 'intellij.platform.core.impl' dependency
    jpsLikeJarDependency("org.jetbrains:annotations:19.0.0", JpsDepScope.COMPILE) // 'intellij.platform.core.impl' dependency
    jpsLikeJarDependency("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.3.70", JpsDepScope.COMPILE) // 'intellij.platform.core.impl' dependency
    jpsLikeModuleDependency(":kotlin-ide.kotlin.core", JpsDepScope.COMPILE)
    jpsLikeJarDependency(intellijPluginDep("java", forIde = true), JpsDepScope.COMPILE) // 'intellij.java.psi' dependency
    jpsLikeJarDependency(intellijDep(forIde = true), JpsDepScope.COMPILE, { includeJars("platform-serviceContainer") }) // 'intellij.platform.serviceContainer' dependency
    jpsLikeJarDependency(intellijDep(forIde = true), JpsDepScope.COMPILE, { includeJars("platform-concurrency") }) // 'intellij.platform.projectModel.impl' dependency
    jpsLikeJarDependency(intellijDep(forIde = true), JpsDepScope.COMPILE, { includeJars("jps-model") }) // 'intellij.platform.projectModel.impl' dependency
    jpsLikeJarDependency("org.jetbrains.intellij.deps:jdom:2.0.6", JpsDepScope.COMPILE) // 'intellij.platform.projectModel.impl' dependency
    jpsLikeJarDependency(intellijDep(forIde = true), JpsDepScope.COMPILE, { includeJars("platform-util-ex") }) // 'intellij.platform.projectModel.impl' dependency
    jpsLikeModuleDependency(":kotlin-ide.kotlin.fir.frontend-independent", JpsDepScope.COMPILE)
    jpsLikeJarDependency("com.google.guava:guava:29.0-jre", JpsDepScope.COMPILE)
    jpsLikeModuleDependency(":kotlin-ide.kotlin.common", JpsDepScope.TEST)
    jpsLikeJarDependency("org.jetbrains.kotlinx:kotlinx-collections-immutable-jvm:0.3.1", JpsDepScope.COMPILE)
}

configurations.all {
    exclude(module = "tests-common") // Avoid classes with same FQN clashing
}

sourceSets {
    "main" {
        
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