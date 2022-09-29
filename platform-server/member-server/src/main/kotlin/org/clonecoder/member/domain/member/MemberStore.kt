package org.clonecoder.member.domain.member

interface MemberStore {
    fun register(memberAccount: MemberAccount)
}