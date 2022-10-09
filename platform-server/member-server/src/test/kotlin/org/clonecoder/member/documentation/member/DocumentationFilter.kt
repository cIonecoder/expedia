package org.clonecoder.member.documentation.member

import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.restdocs.headers.HeaderDocumentation.headerWithName
import org.springframework.restdocs.headers.HeaderDocumentation.requestHeaders
import org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath
import org.springframework.restdocs.payload.PayloadDocumentation.requestFields
import org.springframework.restdocs.payload.PayloadDocumentation.responseFields
import org.springframework.restdocs.restassured3.RestAssuredRestDocumentation.document
import org.springframework.restdocs.restassured3.RestDocumentationFilter

class DocumentationFilter {
    companion object {
        fun `회원 가입`(): RestDocumentationFilter {
            return document("createUser",
                requestHeaders(
                    headerWithName(HttpHeaders.CONTENT_TYPE).description(MediaType.APPLICATION_JSON_VALUE)
                ),
                requestFields(
                    fieldWithPath("email").description("이메일"),
                    fieldWithPath("password").description("패스워드"),
                )
            )
        }

        fun `로그인`(): RestDocumentationFilter {
            return document("login",
                requestHeaders(
                    headerWithName(HttpHeaders.CONTENT_TYPE).description(MediaType.APPLICATION_JSON_VALUE)
                ),
                requestFields(
                    fieldWithPath("email").description("이메일"),
                    fieldWithPath("password").description("패스워드"),
                ),
                responseFields(
                    fieldWithPath("accessToken").description("AccessToken"),
                    fieldWithPath("refreshToken").description("RefreshToken"),
                    fieldWithPath("email").description("이메일"),
                    fieldWithPath("status").description("상태값(SUCCESS: 성공, EXPIRED: 모든 토큰이 만료됨, UNKNOWN: 알 수 없는 에러")
                )
            )
        }
    }
}