package org.clonecoder.auth.application

import org.clonecoder.auth.security.token.JwtTokenProvider
import org.clonecoder.auth.security.token.TokenCommand
import org.clonecoder.auth.security.token.TokenIssueSpec
import org.clonecoder.auth.security.token.TokenPatchSpec
import org.clonecoder.auth.security.token.TokenResponse
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class TokenFacade(
    private val tokenProvider: JwtTokenProvider
) {

    @Transactional
    fun issueTokens(request: TokenCommand.IssueRequest): TokenResponse {
        return tokenProvider.issueTokens(TokenIssueSpec(email = request.email))
    }

    @Transactional
    fun patchTokens(request: TokenCommand.PatchRequest): TokenResponse {
        return tokenProvider.patchTokens(TokenPatchSpec(accessToken = request.accessToken, refreshToken = request.refreshToken))
    }
}