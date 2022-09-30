package org.clonecoder.member.infrastructure.member

import org.clonecoder.member.domain.member.Member
import org.clonecoder.member.domain.member.MemberStore
import org.springframework.stereotype.Component

@Component
class MemberStoreImpl(
    private val memberRepository: MemberRepository
): MemberStore {
    override fun register(member: Member) {
        memberRepository.save(member)
    }

}