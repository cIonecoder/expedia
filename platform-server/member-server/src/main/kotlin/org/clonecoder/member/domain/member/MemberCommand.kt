package org.clonecoder.member.domain.member

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
    }

    data class LoginResponse(
        val accessToken: String,
        val refreshToken: String
    )
}