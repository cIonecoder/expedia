package com.expedia.authentication.domain.user

interface UserCommand {

    data class RegisterUser(
        val email: String,
        val password: String,
        val externalId: String,
    ) {
        fun toEntity() = UserAccount(
            email = email,
            password = password,
            externalId = externalId
        )
    }
}