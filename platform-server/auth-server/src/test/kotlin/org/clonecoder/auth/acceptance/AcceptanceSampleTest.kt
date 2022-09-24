package org.clonecoder.auth.acceptance

import org.clonecoder.auth.acceptance.user.`회원 등록 성공`
import org.clonecoder.auth.acceptance.user.`회원 등록 실패`
import org.clonecoder.auth.acceptance.user.`회원 생성 요청`
import org.clonecoder.auth.payload.userRegisterFailPayloads
import org.clonecoder.auth.payload.userRegisterSuccessPayloads
import org.clonecoder.auth.support.DatabaseCleanup
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.core.spec.style.AnnotationSpec.BeforeEach
import io.kotest.core.spec.style.FeatureSpec
import io.restassured.RestAssured
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.TestConstructor
import org.springframework.test.context.TestConstructor.AutowireMode.ALL

@ActiveProfiles("test")
@TestConstructor(autowireMode = ALL)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AcceptanceSampleTest(
    private val databaseCleanup: DatabaseCleanup,
    @LocalServerPort private val port: Int
): FeatureSpec({
    feature("회원 가입을 한다") {

        RestAssured.port = port
        databaseCleanup.execute()

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