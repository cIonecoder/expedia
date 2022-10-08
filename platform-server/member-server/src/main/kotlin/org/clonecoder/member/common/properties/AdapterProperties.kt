package org.clonecoder.member.common.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "adapter")
class AdapterProperties(
    val authServer: AuthServer
) {

    data class AuthServer(
        val url: String,
        val issueTokenPath: String
    )
}