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
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.assertj.core.api.Assertions.assertThat
import org.clonecoder.member.common.exception.DuplicatedEmailException
import org.clonecoder.member.domain.member.adapter.AuthAdapter
import org.clonecoder.member.payload.accessToken
import org.clonecoder.member.payload.email
import org.clonecoder.member.payload.issueTokenPayloads
import org.clonecoder.member.payload.refreshToken
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
    @MockK private lateinit var authAdapter: AuthAdapter
    @InjectMockKs private lateinit var memberService: MemberService

    init {
        describe("회원 가입") {
            val duplicatedMember = MemberCommand.RegisterMember(email = DUPLICATED_EMAIL, password = validPassword)

            it("이메일이 중복되는 경우 회원 가입 실패") {
                assertThrows<DuplicatedEmailException> { memberService.register(duplicatedMember) }
            }
        }

        describe("로그인") {
            val validMember = MemberCommand.LoginRequest(email = email, password = validPassword)

            it("회원이 존재하면 로그인 성공") {
                val loginMember = withContext(Dispatchers.IO) {
                    memberService.login(validMember)
                }

                assertThat(loginMember.accessToken).isEqualTo(accessToken)
                assertThat(loginMember.refreshToken).isEqualTo(refreshToken)
            }
        }
    }

    override fun beforeEach(testCase: TestCase) {
        // Unit-returning functions to be relaxed
        MockKAnnotations.init(this, relaxUnitFun = true)

        every { memberReader.existsByEmail(DUPLICATED_EMAIL) } returns true
        every { memberStore.register(any()) } just Runs

        every { authAdapter.issueTokens(any()) } returns issueTokenPayloads()
        every { memberReader.existsByEmailAndPassword(any(), any()) } returns true
    }
}