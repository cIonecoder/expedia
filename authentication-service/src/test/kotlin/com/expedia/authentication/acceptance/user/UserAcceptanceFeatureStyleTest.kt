package com.expedia.authentication.acceptance.user

import com.expedia.authentication.acceptance.AcceptanceFeatureStyleTest
import com.expedia.authentication.payload.userRegisterFailPayloads
import com.expedia.authentication.payload.userRegisterSuccessPayloads

internal class UserAcceptanceFeatureStyleTest: AcceptanceFeatureStyleTest({
    feature("회원 가입을 한다") {
        scenario("Success") {
            val response = `회원 생성 요청`(userRegisterSuccessPayloads())
            `회원 등록 성공`(response)
        }
        scenario("Fail") {
            val response = `회원 생성 요청`(userRegisterFailPayloads())
            `회원 등록 실패`(response)
        }
    }
})