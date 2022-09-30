package org.clonecoder.auth.interfaces.dto

import org.clonecoder.auth.security.token.TokenIssueStatus

class TokenDto {

    data class IssueRequest(
        val email: String,
        val password: String
    )

    data class PatchRequest(
        val accessToken: String,
        val refreshToken: String
    )

    data class Response(
        val accessToken: String,
        val refreshToken: String,
        val email: String,
        val status: TokenIssueStatus
    )
}