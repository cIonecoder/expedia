package org.clonecoder.member.common.exception

class NotExistMemberException(
    override val message: String = "Not exist Member"
): RuntimeException(message) {
}