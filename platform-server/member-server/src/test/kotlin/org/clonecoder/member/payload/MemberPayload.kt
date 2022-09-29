package org.clonecoder.member.payload

import org.clonecoder.member.interfaces.member.dto.MemberDto


fun memberRegisterSuccessPayloads(): MemberDto.RegisterRequest {
    val correctPassword = "123!abACC123"

    return MemberDto.RegisterRequest(
        email = "designjava@naver.com",
        password = correctPassword
    )
}

fun memberRegisterFailPayloads(): MemberDto.RegisterRequest {
    val invalidPassword = "1234"

    return MemberDto.RegisterRequest(
        email = "designjava@naver.com",
        password = invalidPassword
    )
}