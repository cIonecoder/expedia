package org.clonecoder.member.domain.member

class MemberCommand {

    data class RegisterMember(
        val email: String,
        val password: String,
    ) {
        fun toEntity() = MemberAccount(
            email = email,
            password = password
        )
    }
}