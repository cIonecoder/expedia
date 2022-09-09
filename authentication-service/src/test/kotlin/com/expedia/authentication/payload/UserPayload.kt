package com.expedia.authentication.payload

import com.expedia.authentication.interfaces.user.dto.UserDto

fun userRegisterSuccessPayloads(): UserDto.RegisterUserRequest {
    val user: UserDto.RegisterUserRequest = UserDto.RegisterUserRequest(
        email = "designjava@naver.com",
        password = "123!abACC123"
    )
    return user
}

fun userRegisterFailPayloads(): UserDto.RegisterUserRequest {
    val user: UserDto.RegisterUserRequest = UserDto.RegisterUserRequest(
        email = "designjava@naver.com",
        password = "1234"
    )
    return user
}