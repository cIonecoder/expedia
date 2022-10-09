package org.clonecoder.member.acceptance.member

import io.restassured.RestAssured
import io.restassured.response.ExtractableResponse
import io.restassured.response.Response
import org.assertj.core.api.Assertions.assertThat
import org.clonecoder.member.common.constant.MEMBER_LOGIN
import org.clonecoder.member.common.constant.MEMBER_REGISTER
import org.clonecoder.member.interfaces.member.dto.MemberDto
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType

internal fun `회원 생성 요청`(member: MemberDto.RegisterRequest): ExtractableResponse<Response> {
    return RestAssured
        .given().log().all()
        .contentType(MediaType.APPLICATION_JSON_VALUE)
        .body(member)
        .`when`().post(MEMBER_REGISTER)
        .then().log().all().extract()
}

internal fun `회원 등록 성공`(response: ExtractableResponse<Response>) =
    assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value())

internal fun `회원 등록 실패`(response: ExtractableResponse<Response>) =
    assertThat(response.statusCode()).isEqualTo(HttpStatus.BAD_REQUEST.value())

internal fun `로그인 요청`(member: MemberDto.LoginRequest): ExtractableResponse<Response> {
    return RestAssured
        .given().log().all()
        .contentType(MediaType.APPLICATION_JSON_VALUE)
        .body(member)
        .`when`().post(MEMBER_LOGIN)
        .then().log().all().extract()
}

internal fun `로그인 성공`(response: ExtractableResponse<Response>) {
    assertThat(response.body().jsonPath().getString("accessToken")).isNotBlank
    assertThat(response.body().jsonPath().getString("refreshToken")).isNotBlank
    assertThat(response.body().jsonPath().getString("email")).isNotBlank
    assertThat(response.body().jsonPath().getString("status")).isNotBlank
}