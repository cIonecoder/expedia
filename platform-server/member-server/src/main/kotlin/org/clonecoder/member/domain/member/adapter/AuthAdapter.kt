package org.clonecoder.member.domain.member.adapter

interface AuthAdapter {
    fun issueTokens(request: AuthApiCallerDto.IssueTokensRequest): AuthApiCallerDto.IssueTokensResponse
}