package com.expedia.authentication.acceptance.user

import com.expedia.authentication.acceptance.AcceptanceTest
import com.expedia.authentication.payload.userRegisterFailPayloads
import com.expedia.authentication.payload.userRegisterSuccessPayloads
import com.expedia.authentication.support.DatabaseCleanup
import org.springframework.boot.web.server.LocalServerPort


internal class UserAcceptanceTest(
    databaseCleanup: DatabaseCleanup,
    @LocalServerPort private val port: Int
): AcceptanceTest(databaseCleanup, port) {
    init {
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
    }
}