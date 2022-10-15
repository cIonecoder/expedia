package org.clonecoder.core.common.exception

import org.clonecoder.core.common.response.ErrorCode
import java.lang.RuntimeException

open class DomainException(
    open val errorCode: ErrorCode = ErrorCode.DOMAIN
): RuntimeException(errorCode.message)