package org.clonecoder.auth.application.user

import org.clonecoder.auth.domain.user.UserCommand
import org.clonecoder.auth.domain.user.UserService
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