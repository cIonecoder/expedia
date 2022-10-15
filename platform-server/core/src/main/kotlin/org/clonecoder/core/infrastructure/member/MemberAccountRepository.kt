package org.clonecoder.core.infrastructure.member

import org.clonecoder.core.domain.member.Member
import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository: JpaRepository<Member, Long> {
    fun existsByEmail(email: String): Boolean

    fun existsByEmailAndPassword(email: String, password: String): Boolean
}