package com.expedia.authentication.interfaces.user.dto

import com.expedia.authentication.interfaces.validator.Password
import javax.validation.constraints.Pattern

class UserDto {

    data class RegisterUserRequest(
        @Pattern(regexp = "^(.+)@(.+)$")
        val email: String,
        @Password
        val password: String,
    )
}