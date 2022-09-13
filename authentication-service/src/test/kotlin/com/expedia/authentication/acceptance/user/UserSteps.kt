package com.expedia.authentication.acceptance.user

import com.expedia.authentication.interfaces.user.dto.UserDto
import io.restassured.RestAssured
import io.restassured.response.ExtractableResponse
import io.restassured.response.Response
import org.assertj.core.api.Assertions.assertThat
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType


internal fun `회원 생성 요청`(user: UserDto.RegisterUserRequest): ExtractableResponse<Response> {
    return RestAssured
        .given().log().all()
        .contentType(MediaType.APPLICATION_JSON_VALUE)
        .body(user)
        .`when`().post("/users")
        .then().log().all().extract()
}

internal fun `회원 등록 성공`(response: ExtractableResponse<Response>) =
    assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value())

internal fun `회원 등록 실패`(response: ExtractableResponse<Response>) =
    assertThat(response.statusCode()).isEqualTo(HttpStatus.BAD_REQUEST.value())