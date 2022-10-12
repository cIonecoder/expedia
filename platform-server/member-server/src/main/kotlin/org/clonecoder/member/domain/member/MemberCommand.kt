package org.clonecoder.member.domain.member

import org.clonecoder.member.domain.member.adapter.AuthApiCallerDto

class MemberCommand {

    data class RegisterMember(
        val email: String,
        val password: String,
    ) {
        fun toEntity() = Member(
            email = email,
            password = password
        )
    }

    data class LoginRequest(
        val email: String,
        val password: String,
    ) {
        fun toEntity() = Member(
            email = email,
            password = password
        )

        fun toIssueTokenRequest() = AuthApiCallerDto.IssueTokensRequest(
            email = email
        )
    }

    data class LoginResponse(
        val accessToken: String,
        val refreshToken: String
    )
}