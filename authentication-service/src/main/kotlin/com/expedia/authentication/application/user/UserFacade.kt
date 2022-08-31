package com.expedia.authentication.application.user

import com.expedia.authentication.domain.user.UserCommand
import com.expedia.authentication.domain.user.UserService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserFacade(
    private val userService: UserService
) {
    @Transactional
    fun register(user: UserCommand.RegisterUser) {
        userService.register(user)
    }
}