package org.clonecoder.core.common.exception

import org.clonecoder.core.common.response.ErrorCode

class NotExistMemberException(
    override val errorCode: ErrorCode = ErrorCode.NOT_EXIST_MEMBER
): DomainException(errorCode)