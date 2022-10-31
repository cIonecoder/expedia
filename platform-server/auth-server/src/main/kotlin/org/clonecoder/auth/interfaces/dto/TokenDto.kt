package org.clonecoder.auth.interfaces.dto

import org.clonecoder.auth.security.token.TokenIssueStatus
import org.clonecoder.core.common.validator.Password
import javax.validation.constraints.Pattern

class TokenDto {

    data class IssueRequest(
        @Pattern(regexp = "^(.+)@(.+)$")
        val email: String,
        @Password
        val password: String
    )

    data class PatchRequest(
        val accessToken: String,
        val refreshToken: String
    )

    data class Response(
        val accessToken: String,
        val refreshToken: String,
        val email: String? = "",
        val status: TokenIssueStatus
    )
}