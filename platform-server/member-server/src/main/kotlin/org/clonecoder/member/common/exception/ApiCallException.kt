package org.clonecoder.member.common.exception

class IssueTokenException(
    override val message: String = "Fail to Issue Tokens"
): RuntimeException(message)