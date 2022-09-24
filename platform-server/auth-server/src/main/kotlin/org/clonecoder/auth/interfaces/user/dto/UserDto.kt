package org.clonecoder.auth.interfaces.user.dto

import org.clonecoder.auth.interfaces.validator.Password
import javax.validation.constraints.Pattern

class UserDto {

    data class RegisterUserRequest(
        @Pattern(regexp = "^(.+)@(.+)$")
        val email: String,
        @Password
        val password: String,
    )
}