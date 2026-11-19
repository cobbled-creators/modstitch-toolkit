import org.gradle.accessors.dm.LibrariesForLibs

plugins {
    `java-gradle-plugin`
    `maven-publish`
    id("org.gradle.kotlin.kotlin-dsl")
    id("com.gradle.plugin-publish")
}

val libs = the<LibrariesForLibs>()

group = "dev.isxander"

repositories {
    mavenLocal()
    mavenCentral()
    gradlePluginPortal()
    maven("https://maven.fabricmc.net")
    maven("https://maven.neoforged.net/releases")
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

dependencies {
    testImplementation(gradleTestKit())
    testImplementation(kotlin("test"))
    testImplementation(libs.junit.jupiter)
    testRuntimeOnly(libs.junit.platform.launcher)
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
}

gradlePlugin {
    website = "https://github.com/isxander/modstitch-toolkit"
    vcsUrl = "https://github.com/isxander/modstitch-toolkit.git"

    repositories {
        maven {
            // Set these variables in gh action secrets
            if (System.getenv("CCM_USER") == null || System.getenv("CCM_PASS") == null) {
                throw RuntimeException("Did you forget your publication credentials?")
            }
            name = "Cobbled Creators Releases"
            url = uri("https://maven.cobbled-creators.org/releases")
            credentials {
                username = System.getenv("CCM_USER").toString()
                password = System.getenv("CCM_PASS").toString()
            }
        }
    }
}

publishing {
    repositories {
        maven {
            // Set these variables in gh action secrets
            if (System.getenv("CCM_USER") == null || System.getenv("CCM_PASS") == null) {
                throw RuntimeException("Did you forget your publication credentials?")
            }
            name = "CobbledCreatorsReleases"
            url = uri("https://maven.cobbled-creators.org/releases")
            credentials {
                username = System.getenv("CCM_USER").toString()
                password = System.getenv("CCM_PASS").toString()
            }
        }
    }
}
