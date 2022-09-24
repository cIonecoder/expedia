package org.clonecoder.auth.infrastructure.user

import org.clonecoder.auth.domain.user.UserAccount
import org.clonecoder.auth.domain.user.UserStore
import org.springframework.stereotype.Component

@Component
class UserStoreImpl(
    private val userAccountRepository: UserAccountRepository
): UserStore {
    override fun register(userAccount: UserAccount) {
        userAccountRepository.save(userAccount)
    }
}