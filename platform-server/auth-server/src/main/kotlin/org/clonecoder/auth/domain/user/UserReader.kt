package org.clonecoder.auth.domain.user

interface UserReader {
    fun existsByEmail(email: String): Boolean
}