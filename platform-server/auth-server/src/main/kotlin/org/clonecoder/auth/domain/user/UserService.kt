package org.clonecoder.auth.domain.user

import org.clonecoder.auth.common.exception.DuplicatedEmailException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(
    private val userStore: UserStore,
    private val userReader: UserReader,
) {
    @Transactional
    fun register(user: UserCommand.RegisterUser) {
        val userAccount = user.toEntity()
        checkEmailDuplication(user.email)
        userStore.register(userAccount)
    }

    private fun checkEmailDuplication(email: String) {
        when (userReader.existsByEmail(email)) {
            true -> throw DuplicatedEmailException()
            false -> return
        }
    }
}