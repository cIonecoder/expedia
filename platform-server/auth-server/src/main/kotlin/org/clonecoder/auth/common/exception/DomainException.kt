package org.clonecoder.auth.common.exception

import org.clonecoder.auth.common.response.ErrorCode
import java.lang.RuntimeException

open class DomainException(
    open val errorCode: ErrorCode = ErrorCode.DOMAIN
): RuntimeException(errorCode.message)