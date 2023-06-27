plugins {
    kotlin("jvm") version "1.8.21"
}

group = "agentsapi.core"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.swagger.parser.v3:swagger-parser:2.1.15")
    testImplementation("io.kotest:kotest-runner-junit5:5.6.2")
    testImplementation(kotlin("test"))
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(11)
}