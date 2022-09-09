package com.expedia.authentication.domain.user

interface UserReader {
    fun existsByEmail(email: String): Boolean
}