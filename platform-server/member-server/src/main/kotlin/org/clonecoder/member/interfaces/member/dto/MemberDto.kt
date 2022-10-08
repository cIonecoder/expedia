package org.clonecoder.member.interfaces.member.dto

import org.clonecoder.member.interfaces.validator.Password
import javax.validation.constraints.Pattern

class MemberDto {

    data class RegisterRequest(
        @Pattern(regexp = "^(.+)@(.+)$")
        val email: String,
        @Password
        val password: String,
    )

    data class LoginRequest(
        @Pattern(regexp = "^(.+)@(.+)$")
        val email: String,
        @Password
        val password: String,
    )

    data class LoginResponse(
        val accessToken: String,
        val refreshToken: String
    )
}