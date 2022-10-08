package org.clonecoder.auth.common.exception

class InvalidTokenException(
    tokenName: String
): RuntimeException("Invalid $tokenName")