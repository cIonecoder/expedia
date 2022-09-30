package org.clonecoder.auth.security.token

data class TokenResponse(
    val accessToken: String,
    val refreshToken: String,
    val email: String,
    val status: TokenIssueStatus
)