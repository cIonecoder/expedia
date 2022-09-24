package org.clonecoder.auth.domain.user

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.core.test.TestCase
import io.mockk.MockKAnnotations
import io.mockk.Runs
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.just
import org.clonecoder.auth.common.exception.DuplicatedEmailException
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
internal class UserServiceTest: DescribeSpec() {

    companion object {
        private const val DUPLICATED_EMAIL = "designjava@naver.com"
    }

    @MockK private lateinit var userStore: UserStore
    @MockK private lateinit var userReader: UserReader
    @InjectMockKs private lateinit var userService: UserService

    init {
        describe("회원 가입") {
            val validUser = UserCommand.RegisterUser(email = DUPLICATED_EMAIL, password = "123!abACC123")

            it("이메일이 중복되는 경우 회원 가입 실패") {
                assertThrows<DuplicatedEmailException> { userService.register(validUser) }
            }
        }
    }

    override fun beforeEach(testCase: TestCase) {
        // Unit-returning functions to be relaxed
        MockKAnnotations.init(this, relaxUnitFun = true)

        every { userReader.existsByEmail(DUPLICATED_EMAIL) } returns true
        every { userStore.register(any()) } just Runs
    }
}