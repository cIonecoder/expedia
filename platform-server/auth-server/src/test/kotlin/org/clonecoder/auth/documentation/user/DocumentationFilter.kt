package org.clonecoder.auth.documentation.user

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
        fun `회원 생성`(): RestDocumentationFilter {
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
    }
}