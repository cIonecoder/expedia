package com.expedia.authentication.payload

import com.expedia.authentication.interfaces.user.dto.UserDto

fun userRegisterSuccessPayloads(): UserDto.RegisterUserRequest {
    val correctPassword = "123!abACC123"

    return UserDto.RegisterUserRequest(
        email = "designjava@naver.com",
        password = correctPassword
    )
}

fun userRegisterFailPayloads(): UserDto.RegisterUserRequest {
    val invalidPassword = "1234"

    return UserDto.RegisterUserRequest(
        email = "designjava@naver.com",
        password = invalidPassword
    )
}