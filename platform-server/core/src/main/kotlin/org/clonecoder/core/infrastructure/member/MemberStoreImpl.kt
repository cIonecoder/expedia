package org.clonecoder.core.infrastructure.member

import org.clonecoder.core.domain.member.Member
import org.clonecoder.core.domain.member.MemberStore
import org.springframework.stereotype.Component

@Component
class MemberStoreImpl(
    private val memberRepository: MemberRepository
): MemberStore {
    override fun register(member: Member) {
        memberRepository.save(member)
    }

}