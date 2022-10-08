package org.clonecoder.member.domain.member

import org.clonecoder.member.common.exception.DuplicatedEmailException
import org.clonecoder.member.common.exception.NotExistMemberException
import org.clonecoder.member.domain.member.adapter.AuthAdapter
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class MemberService(
    private val memberStore: MemberStore,
    private val memberReader: MemberReader,
    private val authAdapter: AuthAdapter
) {
    @Transactional
    fun register(registerMember: MemberCommand.RegisterMember) {
        val member = registerMember.toEntity()
        checkEmailDuplication(member.email)
        memberStore.register(member)
    }

    @Transactional
    fun login(loginMember: MemberCommand.LoginRequest): MemberCommand.LoginResponse {
        val member = loginMember.toEntity()
        when (memberReader.existsByEmailAndPassword(email = member.email, password = member.password)) {
            true -> {
                val response = authAdapter.issueTokens(loginMember.toIssueTokenRequest())
                return response.toMemberCommand()
            }
            false -> throw NotExistMemberException()
        }
    }

    private fun checkEmailDuplication(email: String) {
        when (memberReader.existsByEmail(email)) {
            true -> throw DuplicatedEmailException()
            false -> return
        }
    }
}