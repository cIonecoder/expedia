package org.clonecoder.auth.security.token

data class TokenPatchSpec(
    val accessToken: String,
    val refreshToken: String
)