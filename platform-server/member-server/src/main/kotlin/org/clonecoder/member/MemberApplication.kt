package org.clonecoder.member

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@ConfigurationPropertiesScan("org.clonecoder.core.common.properties")
@EnableJpaRepositories(basePackages = ["org.clonecoder.core.domain"])
@EntityScan(basePackages = ["org.clonecoder.core.domain"])
@SpringBootApplication(
    scanBasePackages = [
        "org.clonecoder.core",
        "org.clonecoder.member"
    ]
)
class MemberApplication

fun main(args: Array<String>) {
    System.setProperty("spring.profiles.default", "local")
    runApplication<MemberApplication>(*args)
}