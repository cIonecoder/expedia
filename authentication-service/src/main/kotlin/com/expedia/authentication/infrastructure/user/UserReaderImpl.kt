package com.expedia.authentication.infrastructure.user

import com.expedia.authentication.domain.user.UserReader
import org.springframework.stereotype.Component

@Component
class UserReaderImpl(
    private val userAccountRepository: UserAccountRepository
): UserReader {
    override fun existsByEmail(email: String): Boolean {
        return userAccountRepository.existsByEmail(email)
    }
}