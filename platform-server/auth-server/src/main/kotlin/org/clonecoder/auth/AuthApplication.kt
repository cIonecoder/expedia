package org.clonecoder.auth

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@EnableCaching
@ConfigurationPropertiesScan("org.clonecoder.auth.common.properties")
@EnableJpaRepositories(basePackages = ["org.clonecoder.core.domain"])
@EntityScan(basePackages = ["org.clonecoder.core.domain"])
@SpringBootApplication(
    scanBasePackages = [
        "org.clonecoder.core",
        "org.clonecoder.auth"
    ]
)
class AuthApplication

fun main(args: Array<String>) {
    System.setProperty("spring.profiles.default", "local")
    runApplication<AuthApplication>(*args)
}