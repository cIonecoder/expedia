package org.clonecoder.auth.common.exception

import org.clonecoder.auth.common.response.CommonResponse
import org.clonecoder.auth.common.response.ErrorCode
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandlerAdvice {

    private val log = LoggerFactory.getLogger(this.javaClass)

    @ExceptionHandler(RedisClientException::class)
    fun redisClientException(e: RedisClientException): ResponseEntity<CommonResponse<*>> {
        return ResponseEntity
            .status(ErrorCode.BAD_REQUEST.status)
            .body(CommonResponse.fail(e.message))
    }

    @ExceptionHandler(InvalidTokenException::class)
    fun invalidTokenException(e: InvalidTokenException): ResponseEntity<CommonResponse<*>> {
        return ResponseEntity
            .status(e.errorCode.status)
            .body(CommonResponse.fail(e.errorCode))
    }

    @ExceptionHandler(ValidationException::class)
    fun validationException(e: ValidationException): ResponseEntity<CommonResponse<*>> {
        return ResponseEntity
            .status(ErrorCode.VALIDATION.status)
            .body(CommonResponse.fail(ErrorCode.VALIDATION, e.errors))
    }

    @ExceptionHandler(Exception::class)
    fun exception(e: Exception): ResponseEntity<CommonResponse<*>> {
        log.error("Not Defined or Not Handled Exception occur", e)
        return ResponseEntity
            .status(ErrorCode.INTERNAL_SERVER_ERROR.status)
            .body(CommonResponse.fail(ErrorCode.INTERNAL_SERVER_ERROR))
    }
}