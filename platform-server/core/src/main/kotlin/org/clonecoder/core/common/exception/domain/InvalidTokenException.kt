package org.clonecoder.core.common.exception.domain

import org.clonecoder.core.common.exception.DomainException
import org.clonecoder.core.common.response.ErrorCode

class InvalidTokenException(
    override val errorCode: ErrorCode = ErrorCode.INVALID_TOKEN,
): DomainException(errorCode)