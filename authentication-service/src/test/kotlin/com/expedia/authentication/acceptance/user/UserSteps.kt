package com.expedia.authentication.acceptance.user

import io.restassured.RestAssured
import io.restassured.response.ExtractableResponse
import io.restassured.response.Response
import org.assertj.core.api.Assertions.assertThat
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType


internal fun `회원 생성 요청`(email: String, password: String): ExtractableResponse<Response> {
    val params: MutableMap<String, String> = HashMap()
    params["email"] = email
    params["password"] = password

    return RestAssured
        .given().log().all()
        .contentType(MediaType.APPLICATION_JSON_VALUE)
        .body(params)
        .`when`().post("/users")
        .then().log().all().extract()
}

internal fun `회원이 생성 됨`(response: ExtractableResponse<Response>) =
    assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value())