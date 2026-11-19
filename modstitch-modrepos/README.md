# MTK: `modrepos`

A Gradle plugin to provide shorthand functions to popular modding maven repositories.

## Repository

Add Cobbled Creators repo in `settings.gradle.kts`

```kotlin
pluginManagement {
    repositories {
        // add after other declared repositories
        maven("https://maven.cobbled-creators.org/releases/")
    }
}
```

## Usage

```kotlin
plugins {
    id("dev.isxander.mtk.modrepos") version "0.1.2-java21"
}

repositories {
    minecraft()
    terraformersMC()
    terraformersMCSnapshots()
    modrinthApi.exclusive()
    curseMaven.exclusive()
    isxander()
    nucleoid()
    nucleoidSnapshots()
    fabricMC()
    neoForged()
    caffeineMC()
    caffeineMCSnapshots()
    kikugie()
    kikugieSnapshots()
    gegy()
    parchment()
    cobblemon()
    cobblemonSnapshots()
    nickimpact()
    cobbledcreators()
    cobbledcreatorsSnapshots()
}
```
