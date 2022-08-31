package com.expedia.authentication.domain.user

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(
    private val userStore: UserStore
) {
    @Transactional
    fun register(user: UserCommand.RegisterUser) {
        val userAccount = user.toEntity()
        userStore.register(userAccount)
    }
}