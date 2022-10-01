package org.clonecoder.auth.application

import org.clonecoder.auth.security.token.JwtTokenProvider
import org.clonecoder.auth.security.token.TokenCommand
import org.clonecoder.auth.security.token.TokenIssueSpec
import org.clonecoder.auth.security.token.TokenResponse
import org.clonecoder.member.application.member.MemberFacade
import org.clonecoder.member.common.exception.NotExistMemberException
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class TokenFacade(
    private val tokenProvider: JwtTokenProvider,
    private val memberFacade: MemberFacade
) {

    private val log = LoggerFactory.getLogger(this.javaClass)

    fun issueTokens(request: TokenCommand.IssueRequest): TokenResponse {
        return when (memberFacade.existsMember(email = request.email, password = request.password)) {
            false -> throw NotExistMemberException()
            true -> tokenProvider.issueTokens(
                TokenIssueSpec(email = request.email)
            )
        }
    }
}