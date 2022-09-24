package org.clonecoder.auth.payload

import org.clonecoder.auth.interfaces.user.dto.UserDto

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