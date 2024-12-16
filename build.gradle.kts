plugins {
    kotlin("jvm") version "2.1.0" apply false
    kotlin("multiplatform") version "2.1.0" apply false
    id("io.ktor.plugin") version "3.0.2" apply false
}

subprojects {
    repositories {
        mavenCentral()
    }

    group = "sky.examples"
    version = "0.0.1"
}
