package org.clonecoder.member.infrastructure.member

import org.clonecoder.member.domain.member.MemberReader
import org.springframework.stereotype.Component

@Component
class MemberReaderImpl(
    private val memberRepository: MemberRepository
): MemberReader {
    override fun existsByEmail(email: String): Boolean {
        return memberRepository.existsByEmail(email)
    }
}