package org.clonecoder.core.common.exception

import org.clonecoder.core.common.response.ErrorCode
import java.lang.RuntimeException

class ConvertException(
   val errorCode: ErrorCode = ErrorCode.CONVERT
): RuntimeException(errorCode.message)