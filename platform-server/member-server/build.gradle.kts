dependencies {
    implementation(project(":core"))
}

tasks.jar { enabled = false }
tasks.bootJar { enabled = true }