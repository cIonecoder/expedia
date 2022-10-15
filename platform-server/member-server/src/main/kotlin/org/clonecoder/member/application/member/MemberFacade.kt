package org.clonecoder.member.application.member

import org.clonecoder.core.domain.member.MemberCommand
import org.clonecoder.core.domain.member.MemberService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional(readOnly = true)
@Service
class MemberFacade(
    private val memberService: MemberService
) {
    @Transactional
    fun register(member: MemberCommand.RegisterMember) {
        memberService.register(member)
    }
}