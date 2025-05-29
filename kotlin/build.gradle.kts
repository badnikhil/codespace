plugins {
    kotlin("jvm") version "1.9.10"
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.squareup.okhttp3:okhttp:4.12.0")
}

kotlin {
    jvmToolchain(17)
}

application {
    mainClass.set("MainKt")
}
