package com.expedia.authentication.infrastructure.user

import com.expedia.authentication.domain.user.UserAccount
import org.springframework.data.jpa.repository.JpaRepository

interface UserAccountRepository: JpaRepository<UserAccount, Long> {
    fun existsByEmail(email: String): Boolean
}