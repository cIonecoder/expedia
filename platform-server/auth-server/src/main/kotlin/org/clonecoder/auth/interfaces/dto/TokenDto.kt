package org.clonecoder.auth.interfaces.dto

import org.clonecoder.auth.common.support.NoArg
import org.clonecoder.auth.security.token.TokenIssueStatus

class TokenDto {

    @NoArg
    data class IssueRequest(
        val email: String,
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