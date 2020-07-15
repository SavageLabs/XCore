import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    kotlin("jvm") version "1.3.72"
    id("com.github.johnrengelman.shadow") version "5.1.0"
}

group = "net.savagelabs"
version = "1.0.2"

repositories {
    mavenCentral()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots")
    maven("https://nexus.savagelabs.net/repository/maven-releases/")
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots")
    maven("https://jitpack.io")
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation(kotlin("reflect"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.7")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.11.0")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.11.0")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.11.1")
    implementation("com.cryptomorin:XSeries:6.0.0")
    implementation("me.rayzr522:jsonmessage:1.2.0")
    implementation("com.github.MinusKube:SmartInvs:master-SNAPSHOT")
    implementation("com.deanveloper:skullcreator:2.0.0")
    implementation("org.litote.kmongo:kmongo-coroutine:4.0.2")
    implementation(project(":SavagePluginX"))

    compileOnly("org.spigotmc:spigot-api:1.16.1-R0.1-SNAPSHOT")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }


    val build by existing {
        dependsOn(shadowJar)
    }


    val shadowJar = named<ShadowJar>("shadowJar") {
        exclude("META-INF/*.DSA")
        exclude("META-INF/*.RSA")
        archiveBaseName.set("XCore")
    }
}