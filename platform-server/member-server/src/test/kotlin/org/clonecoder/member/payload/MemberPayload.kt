package org.clonecoder.member.payload

import org.clonecoder.member.interfaces.member.dto.MemberDto

const val email = "designjava@naver.com"
const val validPassword = "123!abACC123"
const val invalidPassword = "1234"

fun memberRegisterSuccessPayloads(): MemberDto.RegisterRequest {
    return MemberDto.RegisterRequest(
        email = email,
        password = validPassword
    )
}

fun memberRegisterFailPayloads(): MemberDto.RegisterRequest {
    return MemberDto.RegisterRequest(
        email = email,
        password = invalidPassword
    )
}