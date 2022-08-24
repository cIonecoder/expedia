package com.expedia.authentication.documentation.user

import com.expedia.authentication.documentation.Documentation
import com.expedia.authentication.payload.createUserPayloads
import io.restassured.RestAssured
import io.restassured.response.ExtractableResponse
import io.restassured.response.Response
import io.restassured.specification.RequestSpecification
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType

internal class UserDocumentation: Documentation() {

    @Test
    fun `회원 가입을 한다`() {
        val response = `회원 생성 요청`(spec)
        `회원이 생성 됨`(response)
    }
}

internal fun `회원 생성 요청`(spec: RequestSpecification): ExtractableResponse<Response> {
    return RestAssured
        .given(spec).log().all()
        .filter(DocumentationFilter.`회원 생성`())
        .contentType(MediaType.APPLICATION_JSON_VALUE)
        .body(createUserPayloads())
        .`when`().post("/users")
        .then().log().all().extract()
}

internal fun `회원이 생성 됨`(response: ExtractableResponse<Response>) =
    assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value())