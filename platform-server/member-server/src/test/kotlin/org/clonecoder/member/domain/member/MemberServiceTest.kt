package org.clonecoder.member.domain.member

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.core.test.TestCase
import io.mockk.MockKAnnotations
import io.mockk.Runs
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.just
import org.clonecoder.member.common.exception.DuplicatedEmailException
import org.clonecoder.member.payload.validPassword
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
internal class MemberServiceTest: DescribeSpec() {

    companion object {
        private const val DUPLICATED_EMAIL = "designjava@naver.com"
    }

    @MockK private lateinit var memberStore: MemberStore
    @MockK private lateinit var memberReader: MemberReader
    @InjectMockKs private lateinit var memberService: MemberService

    init {
        describe("회원 가입") {
            val duplicatedMember = MemberCommand.RegisterMember(email = DUPLICATED_EMAIL, password = validPassword)

            it("이메일이 중복되는 경우 회원 가입 실패") {
                assertThrows<DuplicatedEmailException> { memberService.register(duplicatedMember) }
            }
        }
    }

    override fun beforeEach(testCase: TestCase) {
        // Unit-returning functions to be relaxed
        MockKAnnotations.init(this, relaxUnitFun = true)

        every { memberReader.existsByEmail(DUPLICATED_EMAIL) } returns true
        every { memberStore.register(any()) } just Runs

        every { memberReader.existsByEmailAndPassword(any(), any()) } returns true
    }
}