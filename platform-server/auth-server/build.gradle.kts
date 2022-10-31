dependencies {
    // modules
    implementation(project(":core"))

    // others
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("io.jsonwebtoken:jjwt:0.9.1")
    implementation("org.springframework.boot:spring-boot-starter-cache")
    implementation("org.springframework.boot:spring-boot-starter-data-redis")
    testImplementation("org.springframework.security:spring-security-test")
}

tasks.jar { enabled = false }
tasks.bootJar { enabled = true }