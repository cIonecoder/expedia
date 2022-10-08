noArg {
    annotation("org.clonecoder.member.common.support.NoArg")
}

tasks.jar { enabled = false }
tasks.bootJar { enabled = true }