package org.clonecoder.auth.security.token

class TokenCommand {

    data class IssueRequest(
        val email: String,
    )

    data class PatchRequest(
        val accessToken: String,
        val refreshToken: String
    )
}