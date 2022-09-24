plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    id("org.asciidoctor.jvm.convert")
    kotlin("jvm")
    kotlin("plugin.spring")
    kotlin("plugin.jpa")
}

java.sourceCompatibility = JavaVersion.VERSION_11
tasks.jar { enabled = false }

allprojects {
    group = "org.clonecoder"
    version = "0.0.1-SNAPSHOT"

    repositories {
        mavenCentral()
    }
}

subprojects {

    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "org.asciidoctor.jvm.convert")
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "org.jetbrains.kotlin.plugin.spring")
    apply(plugin = "org.jetbrains.kotlin.plugin.jpa")

    allOpen{
        annotation("javax.persistence.Entity")
        annotation("javax.persistence.MappedSuperclass")
        annotation("javax.persistence.Embeddable")
    }


    dependencies {
        // Kotlin Standard Library
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

        // Spring Boot Starter
        implementation("org.springframework.boot:spring-boot-starter-web")
        implementation("org.springframework.boot:spring-boot-starter-validation")

        // Google
        implementation("com.google.guava:guava:31.1-jre")

        // Kafka

        // Databasse
        implementation("org.springframework.boot:spring-boot-starter-data-jpa")
        runtimeOnly("mysql:mysql-connector-java")
        runtimeOnly("com.h2database:h2")

        // Spring Rest Docs
        testImplementation("org.springframework.restdocs:spring-restdocs-restassured")
        testImplementation("io.rest-assured:rest-assured")
        testImplementation("org.springframework.restdocs:spring-restdocs-asciidoctor")

        // Test
        testImplementation("org.springframework.boot:spring-boot-starter-test") {
            exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
        }
        testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.2")
        testImplementation("io.kotest.extensions:kotest-extensions-spring:1.1.0")
        testImplementation("com.ninja-squad:springmockk:3.1.1")
        testImplementation("io.mockk:mockk:1.12.3")
        testImplementation("io.kotest:kotest-runner-junit5:5.1.0")
        testImplementation("io.kotest:kotest-assertions-core:5.1.0")

        // Annotation Processing Tool
        annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    }

    sourceSets.main.configure {
        resources.srcDirs("src/main/resources/common", "src/main/resources/config")
    }

    tasks.processResources {
        duplicatesStrategy = DuplicatesStrategy.INCLUDE
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "11"
        }
    }

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
}