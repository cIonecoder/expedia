package org.clonecoder.member.acceptance.member

import io.kotest.core.test.TestCase
import org.clonecoder.member.acceptance.AcceptanceTest
import org.clonecoder.member.payload.memberRegisterFailPayloads
import org.clonecoder.member.payload.memberRegisterSuccessPayloads
import org.clonecoder.member.support.DatabaseCleanup
import org.springframework.boot.web.server.LocalServerPort


internal class MemberAcceptanceTest(
    databaseCleanup: DatabaseCleanup,
    @LocalServerPort private val port: Int
): AcceptanceTest(databaseCleanup, port) {
    init {
        feature("회원 가입을 한다") {
            scenario("Success") {
                val response = `회원 생성 요청`(memberRegisterSuccessPayloads())
                `회원 등록 성공`(response)
            }
            scenario("Fail") {
                val response = `회원 생성 요청`(memberRegisterFailPayloads())
                `회원 등록 실패`(response)
            }
        }
    }

    override fun beforeEach(testCase: TestCase) {
        super.beforeEach(testCase)
    }
}