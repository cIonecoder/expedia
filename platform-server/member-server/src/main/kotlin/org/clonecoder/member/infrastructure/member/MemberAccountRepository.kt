package org.clonecoder.member.infrastructure.member

import org.clonecoder.member.domain.member.MemberAccount
import org.springframework.data.jpa.repository.JpaRepository

interface MemberAccountRepository: JpaRepository<MemberAccount, Long> {
    fun existsByEmail(email: String): Boolean
}