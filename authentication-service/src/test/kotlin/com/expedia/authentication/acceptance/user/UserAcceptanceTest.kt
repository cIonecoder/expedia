package com.expedia.authentication.acceptance.user

import com.expedia.authentication.acceptance.AcceptanceTest
import com.expedia.authentication.payload.userRegisterSuccessPayloads
import org.junit.jupiter.api.Test

internal class UserAcceptanceTest: AcceptanceTest() {

    @Test
    fun `회원 가입을 한다`() {
        val response = `회원 생성 요청`(userRegisterSuccessPayloads())
        `회원 등록 성공`(response)
    }
}