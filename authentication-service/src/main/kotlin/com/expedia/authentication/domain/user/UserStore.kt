package com.expedia.authentication.domain.user

interface UserStore {
    fun register(userAccount: UserAccount)
}