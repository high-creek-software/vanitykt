
plugins {
    kotlin("jvm") version "1.6.10" apply false
    kotlin("kapt") version "1.6.10" apply false
    kotlin("plugin.serialization") version "1.5.31" apply false
}

group = "io.highcreeksoftware"
version = "1.0-SNAPSHOT"

allprojects {
    repositories {
        mavenCentral()
    }
}