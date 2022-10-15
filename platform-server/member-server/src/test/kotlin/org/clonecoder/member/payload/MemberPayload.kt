package org.clonecoder.member.payload

import org.clonecoder.member.domain.member.adapter.AuthApiCallerDto
import org.clonecoder.member.interfaces.member.dto.MemberDto

const val email = "designjava@naver.com"
const val validPassword = "123!abACC123"
const val invalidPassword = "1234"
const val accessToken = "test_accessToken"
const val refreshToken = "test_refreshToken"

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

fun memberLoginSuccessPayloads(): MemberDto.LoginRequest {
    return MemberDto.LoginRequest(
        email = email,
        password = validPassword
    )
}

fun issueTokenPayloads(): AuthApiCallerDto.IssueTokensResponse {
    return AuthApiCallerDto.IssueTokensResponse(
        accessToken = accessToken,
        refreshToken = refreshToken,
        email = email,
        status = AuthApiCallerDto.TokenResponseStatus.SUCCESS
    )
}