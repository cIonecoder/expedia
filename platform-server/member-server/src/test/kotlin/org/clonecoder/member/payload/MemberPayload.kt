package org.clonecoder.member.payload

import org.clonecoder.member.interfaces.member.dto.MemberDto
import java.util.UUID

const val validPassword = "123!abACC123"
const val invalidPassword = "1234"

fun memberRegisterSuccessPayloads(): MemberDto.RegisterRequest {
    return MemberDto.RegisterRequest(
        email = UUID.randomUUID().toString().substring(0, 8) + "@naver.com",
        password = validPassword
    )
}

fun memberRegisterFailPayloads(): MemberDto.RegisterRequest {
    return MemberDto.RegisterRequest(
        email = UUID.randomUUID().toString().substring(0, 8) + "@naver.com",
        password = invalidPassword
    )
}