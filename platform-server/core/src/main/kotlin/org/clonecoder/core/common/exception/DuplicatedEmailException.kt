package org.clonecoder.core.common.exception

import org.clonecoder.core.common.response.ErrorCode

class DuplicatedEmailException(
    override val errorCode: ErrorCode = ErrorCode.DUPLICATED_EMAIL
): DomainException(errorCode)