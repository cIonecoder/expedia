package org.clonecoder.member.infrastructure.member

import org.clonecoder.member.domain.member.MemberReader
import org.springframework.stereotype.Component

@Component
class MemberReaderImpl(
    private val memberAccountRepository: MemberAccountRepository
): MemberReader {
    override fun existsByEmail(email: String): Boolean {
        return memberAccountRepository.existsByEmail(email)
    }
}