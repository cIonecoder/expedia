package org.clonecoder.auth.common.exception

import org.clonecoder.auth.common.response.ErrorCode
import org.springframework.validation.Errors

class ValidationException(
    errorCode: ErrorCode = ErrorCode.VALIDATION,
    val errors: Errors? = null
): Exception(errorCode.message)