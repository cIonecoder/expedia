package com.expedia.authentication.infrastructure.user

import com.expedia.authentication.domain.user.UserAccount
import com.expedia.authentication.domain.user.UserStore
import org.springframework.stereotype.Component

@Component
class UserStoreImpl(
    private val userAccountRepository: UserAccountRepository
): UserStore {
    override fun register(user: UserAccount) {
        userAccountRepository.save(user)
    }
}