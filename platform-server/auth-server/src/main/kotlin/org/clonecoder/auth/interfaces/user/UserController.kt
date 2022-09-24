package org.clonecoder.auth.interfaces.user

import org.clonecoder.auth.application.user.UserFacade
import org.clonecoder.auth.interfaces.user.dto.UserDto
import org.clonecoder.auth.interfaces.user.mapper.UserDtoMapper
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
class UserController(
    private val userFacade: UserFacade
) {
    @PostMapping("/users")
    fun register(
        @RequestBody @Valid request: UserDto.RegisterUserRequest
    ) {
        val user = UserDtoMapper.of(request)
        userFacade.register(user)
    }
}