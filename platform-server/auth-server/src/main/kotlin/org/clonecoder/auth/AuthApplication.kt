package org.clonecoder.auth

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@EnableCaching
@ConfigurationPropertiesScan("org.clonecoder.auth.common.properties")
@SpringBootApplication(
    scanBasePackages = [
        "org.clonecoder.auth",
        "org.clonecoder.member"
    ]
)
class AuthApplication

fun main(args: Array<String>) {
    System.setProperty("spring.profiles.default", "local")
    runApplication<AuthApplication>(*args)
}