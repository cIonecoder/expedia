package com.expedia.authentication.interfaces.user.mapper

import com.expedia.authentication.domain.UserCommand
import com.expedia.authentication.interfaces.user.dto.UserDto

class UserDtoMapper {

    companion object {
        fun of(request: UserDto.RegisterUserRequest): UserCommand.RegisterUser {
            return UserCommand.RegisterUser(
                email = request.email,
                password = request.password,
                externalId = request.externalId
            )
        }
    }
}