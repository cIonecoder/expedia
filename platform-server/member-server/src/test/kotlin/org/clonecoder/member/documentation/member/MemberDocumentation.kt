package org.clonecoder.member.documentation.member

import org.clonecoder.member.documentation.Documentation
import io.restassured.RestAssured
import io.restassured.response.ExtractableResponse
import io.restassured.response.Response
import io.restassured.specification.RequestSpecification
import org.assertj.core.api.Assertions.assertThat
import org.clonecoder.core.common.constant.MEMBER_REGISTER
import org.clonecoder.member.payload.memberRegisterSuccessPayloads
import org.junit.jupiter.api.Test
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType

internal class MemberDocumentation: Documentation() {

    @Test
    fun `회원 가입을 한다`() {
        val response = `회원 생성 요청`(spec)
        `회원이 생성 됨`(response)
    }
}

internal fun `회원 생성 요청`(spec: RequestSpecification): ExtractableResponse<Response> {
    return RestAssured
        .given(spec).log().all()
        .filter(DocumentationFilter.`회원 가입`())
        .contentType(MediaType.APPLICATION_JSON_VALUE)
        .body(memberRegisterSuccessPayloads())
        .`when`().post(MEMBER_REGISTER)
        .then().log().all().extract()
}

internal fun `회원이 생성 됨`(response: ExtractableResponse<Response>) =
    assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value())

internal fun `토큰이 생성 됨`(response: ExtractableResponse<Response>) {
    assertThat(response.body().jsonPath().getString("accessToken")).isNotBlank
    assertThat(response.body().jsonPath().getString("refreshToken")).isNotBlank
}