package org.clonecoder.auth.acceptance.user

import org.clonecoder.auth.acceptance.AcceptanceTest
import org.clonecoder.auth.payload.userRegisterFailPayloads
import org.clonecoder.auth.payload.userRegisterSuccessPayloads
import org.clonecoder.auth.support.DatabaseCleanup
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.security.test.context.support.WithAnonymousUser


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