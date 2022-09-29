package org.clonecoder.member.common.exception

class DuplicatedEmailException(
    override val message: String = "Duplicated Email"
): RuntimeException(message) {
}