package org.clonecoder.auth.infrastructure.user

import org.clonecoder.auth.domain.user.UserAccount
import org.springframework.data.jpa.repository.JpaRepository

interface UserAccountRepository: JpaRepository<UserAccount, Long> {
    fun existsByEmail(email: String): Boolean
}