package org.clonecoder.member.domain.member

import org.clonecoder.member.common.exception.DuplicatedEmailException
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

    private fun checkEmailDuplication(email: String) {
        when (memberReader.existsByEmail(email)) {
            true -> throw DuplicatedEmailException()
            false -> return
        }
    }

    fun existsByEmailAndPassword(email: String, password: String): Boolean {
        return memberReader.existsByEmailAndPassword(email = email, password = password)
    }
}