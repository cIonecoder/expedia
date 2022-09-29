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
}