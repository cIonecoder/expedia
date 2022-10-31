package org.clonecoder.core.infrastructure.member

import org.clonecoder.core.domain.member.MemberReader
import org.springframework.stereotype.Component

@Component
class MemberReaderImpl(
    private val memberRepository: MemberRepository
): MemberReader {
    override fun existsByEmail(email: String): Boolean {
        return memberRepository.existsByEmail(email)
    }

    override fun existsByEmailAndPassword(email: String, password: String): Boolean {
        return memberRepository.existsByEmailAndPassword(email, password)
    }
}