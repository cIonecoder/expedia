package org.clonecoder.auth.domain.user

class UserCommand {

    data class RegisterUser(
        val email: String,
        val password: String,
    ) {
        fun toEntity() = UserAccount(
            email = email,
            password = password
        )
    }
}