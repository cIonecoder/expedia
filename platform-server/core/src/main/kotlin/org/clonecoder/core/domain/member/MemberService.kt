package org.clonecoder.core.domain.member

import org.clonecoder.core.common.exception.DuplicatedEmailException
import org.clonecoder.core.common.exception.NotExistMemberException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class MemberService(
    private val memberStore: MemberStore,
    private val memberReader: MemberReader,
) {
    @Transactional
    fun register(registerMember: MemberCommand.RegisterMember) {
        val member = registerMember.toEntity()
        checkEmailDuplication(member.email)
        memberStore.register(member)
    }

    @Transactional
    fun login(loginMember: MemberCommand.LoginRequest): Boolean {
        val member = loginMember.toEntity()
        when (memberReader.existsByEmailAndPassword(email = member.email, password = member.password)) {
            true -> return true
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