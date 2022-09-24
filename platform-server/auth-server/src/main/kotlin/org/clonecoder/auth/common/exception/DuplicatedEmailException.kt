package org.clonecoder.auth.common.exception

class DuplicatedEmailException(
    override val message: String = "Duplicated Email"
): RuntimeException(message) {
}