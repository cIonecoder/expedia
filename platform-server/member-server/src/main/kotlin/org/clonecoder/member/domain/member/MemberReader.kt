package org.clonecoder.member.domain.member

interface MemberReader {
    fun existsByEmail(email: String): Boolean

    fun existsByEmailAndPassword(email: String, password: String): Boolean
}