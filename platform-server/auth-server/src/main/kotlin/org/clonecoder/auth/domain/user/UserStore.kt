package org.clonecoder.auth.domain.user

interface UserStore {
    fun register(userAccount: UserAccount)
}