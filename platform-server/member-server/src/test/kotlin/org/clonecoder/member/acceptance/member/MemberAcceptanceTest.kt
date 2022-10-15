package org.clonecoder.member.acceptance.member

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

        // TODO 인수테스트 대상 API 가 성공하기 위해서 외부 API 에 의존하는 상황이라면 어떻게 테스트하지?
        /*
        feature("로그인을 한다") {
            scenario("아이디와 패스워드가 일치하면 AccessToken 과 RefreshToken 이 발급된다.") {
                val registerResponse = `회원 생성 요청`(member = MemberDto.RegisterRequest(
                    email = "test@gmail.com",
                    password = validPassword
                ))
                `회원 등록 성공`(registerResponse)

                val loginResponse = `로그인 요청`(memberLoginSuccessPayloads())
                `로그인 성공`(loginResponse)
            }
        }
         */
    }
}