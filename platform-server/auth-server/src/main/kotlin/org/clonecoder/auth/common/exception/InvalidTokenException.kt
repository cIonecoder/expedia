package org.clonecoder.auth.common.exception

import org.clonecoder.auth.common.response.ErrorCode

class InvalidTokenException(
    override val errorCode: ErrorCode = ErrorCode.INVALID_TOKEN,
): DomainException(errorCode)