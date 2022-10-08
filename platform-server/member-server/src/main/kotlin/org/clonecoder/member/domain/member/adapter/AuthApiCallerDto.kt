package org.clonecoder.member.domain.member.adapter

import org.clonecoder.member.common.support.NoArg
import org.clonecoder.member.domain.member.MemberCommand

class AuthApiCallerDto {

    data class IssueTokensRequest(
        val email: String
    )

    @NoArg
    data class IssueTokensResponse(
        val accessToken: String,
        val refreshToken: String,
        val email: String? = "",
        val status: TokenResponseStatus
    ) {
        fun toMemberCommand() = MemberCommand.LoginResponse(
            accessToken = accessToken,
            refreshToken = refreshToken
        )
    }

    enum class TokenResponseStatus {
        SUCCESS, EXPIRED, UNKNOWN
    }
}