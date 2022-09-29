package org.clonecoder.member.application.member

import org.clonecoder.member.domain.member.MemberCommand
import org.clonecoder.member.domain.member.MemberService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class MemberFacade(
    private val memberService: MemberService
) {
    @Transactional
    fun register(user: MemberCommand.RegisterMember) {
        memberService.register(user)
    }
}