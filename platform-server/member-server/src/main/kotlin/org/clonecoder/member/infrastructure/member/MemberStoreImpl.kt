package org.clonecoder.member.infrastructure.member

import org.clonecoder.member.domain.member.MemberAccount
import org.clonecoder.member.domain.member.MemberStore
import org.springframework.stereotype.Component

@Component
class MemberStoreImpl(
    private val memberAccountRepository: MemberAccountRepository
): MemberStore {
    override fun register(memberAccount: MemberAccount) {
        memberAccountRepository.save(memberAccount)
    }
}