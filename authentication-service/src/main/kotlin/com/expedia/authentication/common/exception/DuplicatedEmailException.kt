package com.expedia.authentication.common.exception

class DuplicatedEmailException(
    override val message: String = "Duplicated Email"
): RuntimeException(message) {
}