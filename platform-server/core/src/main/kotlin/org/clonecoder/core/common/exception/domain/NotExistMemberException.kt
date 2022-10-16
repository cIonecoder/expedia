package org.clonecoder.core.common.exception.domain

import org.clonecoder.core.common.exception.DomainException
import org.clonecoder.core.common.response.ErrorCode

class NotExistMemberException(
    override val errorCode: ErrorCode = ErrorCode.NOT_EXIST_MEMBER
): DomainException(errorCode)