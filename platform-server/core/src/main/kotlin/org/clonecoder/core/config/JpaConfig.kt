package org.clonecoder.core.config

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@EnableJpaAuditing
@EnableJpaRepositories(basePackages = ["org.clonecoder.*"])
@EntityScan(basePackages = ["org.clonecoder.*"])
@Configuration
class JpaConfig {
}