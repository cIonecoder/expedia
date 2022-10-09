package org.clonecoder.auth.common.exception

import org.clonecoder.auth.common.response.ErrorCode

class InvalidTokenException(
    val errorCode: ErrorCode = ErrorCode.INVALID_TOKEN,
    tokenName: String
): RuntimeException("Invalid $tokenName")