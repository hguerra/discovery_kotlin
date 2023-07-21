/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Kotlin application project to get you started.
 * For more details on building Java & JVM projects, please refer to https://docs.gradle.org/8.2.1/userguide/building_java_projects.html in the Gradle documentation.
 */

plugins {
  // Apply the org.jetbrains.kotlin.jvm Plugin to add support for Kotlin.
  id("org.jetbrains.kotlin.jvm") version "1.8.20"

  // Apply the application plugin to add support for building a CLI application in Java.
  application

  // CI
  jacoco
  id("io.gitlab.arturbosch.detekt") version "1.23.0"
  id("com.ncorti.ktfmt.gradle") version "0.12.0"
}

version = "0.1"
group = "br.com.abc"

repositories {
  // Use Maven Central for resolving dependencies.
  mavenCentral()

  maven {
    url = uri("https://packages.confluent.io/maven/")
  }
}

dependencies {
  // Use the Kotlin JUnit 5 integration.
  testRuntimeOnly("org.junit.platform:junit-platform-launcher")
  testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
  testImplementation("org.junit.jupiter:junit-jupiter-engine:5.9.2")
  testImplementation("io.mockk:mockk:1.13.5")
  testImplementation("io.kotest:kotest-assertions-core:5.6.2")
  testImplementation("com.tngtech.archunit:archunit:1.0.1")

  // This dependency is used by the application.
  implementation("org.slf4j:slf4j-api:2.0.7")
  implementation("ch.qos.logback:logback-classic:1.4.8")
  implementation("com.google.guava:guava:31.1-jre")
  implementation("org.postgresql:postgresql:42.6.0")
  implementation("com.zaxxer:HikariCP:5.0.1")

  // GCP
//  https://github.com/apache/beam-starter-kotlin/blob/main/app/build.gradle.kts
  implementation("com.google.cloud:google-cloud-logging-logback:0.130.17-alpha")
}

// Apply a specific Java toolchain to ease working on different environments.
java {
  toolchain {
    languageVersion.set(JavaLanguageVersion.of(17))
  }
}

application {
  // Define the main class for the application.
  mainClass.set("br.com.abc.def.AppKt")
}

jacoco {
  toolVersion = "0.8.10"
}

detekt {
  toolVersion = "1.23.0"
  config.setFrom(file("config/detekt/detekt.yml"))
  buildUponDefaultConfig = true
}

tasks.withType<Jar> {
  manifest {
    attributes["Main-Class"] = "br.com.abc.def.AppKt"
  }
}

tasks.named<Test>("test") {
  // Use JUnit Platform for unit tests.
  useJUnitPlatform()

  maxHeapSize = "512m"

  finalizedBy(tasks.named("jacocoTestReport"))
}

tasks.named<JacocoReport>("jacocoTestReport") {
  dependsOn(tasks.named("test"))

  reports {
    xml.required.set(true)
    csv.required.set(false)
    html.required.set(true)
  }
}

tasks.named<JacocoCoverageVerification>("jacocoTestCoverageVerification") {
  violationRules {
    rule {
      element = "SOURCEFILE"
      limit {
        minimum = "0.0".toBigDecimal()
      }
    }
  }
}
