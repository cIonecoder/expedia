package org.clonecoder.auth.common.exception

import org.clonecoder.auth.common.response.ErrorCode

class RedisClientException(
    val errorCode: ErrorCode = ErrorCode.REDIS_CLIENT,
): RuntimeException(errorCode.message)