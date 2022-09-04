package com.expedia.authentication.payload

import com.expedia.authentication.interfaces.user.dto.UserDto

fun createUserPayloads(): UserDto.RegisterUserRequest {
    val user: UserDto.RegisterUserRequest = UserDto.RegisterUserRequest(
        email = "designjava@naver.com",
        password = "1234"
    )
    return user
}