package com.expedia.authentication.interfaces.user

import com.expedia.authentication.application.user.UserFacade
import com.expedia.authentication.interfaces.user.dto.UserDto
import com.expedia.authentication.interfaces.user.mapper.UserDtoMapper
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RequestMapping("/user")
@RestController
class UserController(
    private val userFacade: UserFacade
) {
    @PostMapping("/register")
    fun register(
        @RequestBody @Valid request: UserDto.RegisterUserRequest
    ) {
        val user = UserDtoMapper.of(request)
        userFacade.register(user)
    }
}