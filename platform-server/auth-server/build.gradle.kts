dependencies {
    // modules
//    implementation(project(":member-server"))

    // others
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("io.jsonwebtoken:jjwt:0.9.1")
    implementation("org.redisson:redisson:3.17.6")
    implementation("org.springframework.boot:spring-boot-starter-cache")
    implementation("org.springframework.boot:spring-boot-starter-data-redis")
    testImplementation("org.springframework.security:spring-security-test")
}

noArg {
    annotation("org.clonecoder.auth.common.support.NoArg")
}

tasks.jar { enabled = false }
tasks.bootJar { enabled = true }