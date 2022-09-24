package org.clonecoder.auth.interfaces.user.mapper

import org.clonecoder.auth.domain.user.UserCommand
import org.clonecoder.auth.interfaces.user.dto.UserDto

class UserDtoMapper {

    companion object {
        fun of(request: UserDto.RegisterUserRequest): UserCommand.RegisterUser =
            UserCommand.RegisterUser(
                email = request.email,
                password = request.password,
            )
    }
}