package org.clonecoder.core.domain.member

interface MemberStore {
    fun register(member: Member)
}