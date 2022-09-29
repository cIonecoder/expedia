package org.clonecoder.member.domain.member

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class MemberService(
    private val memberStore: MemberStore,
    private val memberReader: MemberReader,
) {
    @Transactional
    fun register(member: MemberCommand.RegisterMember) {
        val memberAccount = member.toEntity()
        checkEmailDuplication(member.email)
        memberStore.register(memberAccount)
    }

    private fun checkEmailDuplication(email: String) {
        when (memberReader.existsByEmail(email)) {
            true -> throw org.clonecoder.member.common.exception.DuplicatedEmailException()
            false -> return
        }
    }
}