package com.expedia.authentication.domain

interface UserCommand {

    data class RegisterUser(
        val email: String,
        val password: String,
        val externalId: String,
    )
}