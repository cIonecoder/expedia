package com.expedia.authentication.acceptance.user

import com.expedia.authentication.acceptance.AcceptanceTest
import com.expedia.authentication.support.DatabaseCleanup
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

internal class UserAcceptanceTest(
    @Autowired databaseCleanup: DatabaseCleanup
): AcceptanceTest(databaseCleanup) {

    @Test
    fun `회원 가입을 한다`() {
        val response = `회원 생성 요청`("designjava@naver.com", "jungho")
        `회원이 생성 됨`(response)
    }
}