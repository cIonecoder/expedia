import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.6.6"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    id("org.asciidoctor.jvm.convert") version "3.3.2"
    kotlin("jvm") version "1.6.10"
    kotlin("plugin.spring") version "1.6.10"
}

group = "com.expedia"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web:2.6.6")
    implementation("org.springframework.boot:spring-boot-starter-actuator:2.6.6")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:2.6.6")
//    implementation("org.springframework.boot:spring-boot-starter-security:2.6.6")
    implementation("org.springframework.boot:spring-boot-starter-validation:2.6.6")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.2")
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.6.10")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.6.10")
    implementation("io.jsonwebtoken:jjwt:0.9.1")
    implementation("javax.xml.bind:jaxb-api:2.4.0-b180830.0359")
    implementation("io.jsonwebtoken:jjwt-jackson:0.11.2")
    implementation("io.jsonwebtoken:jjwt-api:0.11.2")
    implementation("net.rakugakibox.spring.boot:logback-access-spring-boot-starter:2.7.1")
    implementation("com.google.guava:guava:31.1-jre")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor:2.6.6")
    developmentOnly("org.springframework.boot:spring-boot-devtools:2.6.6")
    runtimeOnly("mysql:mysql-connector-java:8.0.28")
    runtimeOnly("com.h2database:h2")

    // Spring Rest Docs
    testImplementation("org.springframework.restdocs:spring-restdocs-restassured:2.0.6.RELEASE")
    testImplementation("io.rest-assured:rest-assured:3.3.0")
    testImplementation("org.springframework.restdocs:spring-restdocs-asciidoctor:2.0.5.RELEASE")

    // kotlin test
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.0-native-mt")
    testImplementation("io.kotest.extensions:kotest-extensions-spring:1.1.0")
    testImplementation("com.ninja-squad:springmockk:3.1.1")
    testImplementation("io.mockk:mockk:1.12.3")
    testImplementation("io.kotest:kotest-runner-junit5:5.1.0")
    testImplementation("io.kotest:kotest-assertions-core:5.1.0")

    // spring test
    testImplementation("org.springframework.boot:spring-boot-starter-test:2.6.6") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
}

// Kotlin Compile
tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

//// JUnit Test Target
//tasks.withType<Test> {
//    useJUnitPlatform()
//    filter {
//        includeTestsMatching("*.documentation.*")
//    }
//}

// Asciidoctor
tasks {

    val snippetsDir by extra { file("build/generated-snippets") }

    test {
        useJUnitPlatform()
        systemProperty("org.springframework.restdocs.outputDir", snippetsDir)
        outputs.dir(snippetsDir)
    }

    build {
        dependsOn("copyDocument")
    }

    asciidoctor {
        inputs.dir(snippetsDir)

        dependsOn(test)

        doFirst {
            delete("src/main/resources/static/docs")
        }
    }

    register<Copy>("copyDocument") {
        dependsOn(asciidoctor)

        destinationDir = file(".")
        from(asciidoctor.get().outputDir) {
            into("src/main/resources/static/docs")
        }
    }

    bootJar {
        dependsOn(asciidoctor)

        from(asciidoctor.get().outputDir) {
            into("BOOT-INF/classes/static/docs")
        }
    }
}
