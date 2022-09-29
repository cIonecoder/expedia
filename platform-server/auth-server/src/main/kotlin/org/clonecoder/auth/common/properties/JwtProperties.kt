package org.clonecoder.auth.common.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "security.jwt")
data class JwtProperties(
    val token: TokenProperties
) {

    @ConstructorBinding
    data class TokenProperties(
        val secretKey: String,
        val expireLength: Long
    )
}