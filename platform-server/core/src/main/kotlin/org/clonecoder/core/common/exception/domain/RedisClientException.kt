package org.clonecoder.core.common.exception.domain

import org.clonecoder.core.common.response.ErrorCode

class RedisClientException(
    val errorCode: ErrorCode = ErrorCode.REDIS_CLIENT,
): RuntimeException(errorCode.message)