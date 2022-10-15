package org.clonecoder.core.common.exception

import org.apache.commons.lang3.exception.ExceptionUtils
import org.clonecoder.core.common.response.CommonResponse
import org.clonecoder.core.common.response.ErrorCode
import org.slf4j.LoggerFactory
import org.slf4j.event.Level
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandlerAdvice {

    companion object {
        private val log = LoggerFactory.getLogger(this::class.java)
    }

    @ExceptionHandler(RedisClientException::class)
    fun redisClientException(e: RedisClientException): ResponseEntity<CommonResponse<*>> {
        ExceptionLogHandler.printLog(e.errorCode, ExceptionUtils.getStackTrace(e))
        return ResponseEntity
            .status(ErrorCode.BAD_REQUEST.status)
            .body(CommonResponse.fail(e.errorCode))
    }

    @ExceptionHandler(InvalidTokenException::class)
    fun invalidTokenException(e: InvalidTokenException): ResponseEntity<CommonResponse<*>> {
        ExceptionLogHandler.printLog(e.errorCode, ExceptionUtils.getStackTrace(e))
        return ResponseEntity
            .status(e.errorCode.status)
            .body(CommonResponse.fail(e.errorCode))
    }

    @ExceptionHandler(ValidationException::class)
    fun validationException(e: ValidationException): ResponseEntity<CommonResponse<*>> {
        ExceptionLogHandler.printLog(e.errorCode, ExceptionUtils.getStackTrace(e))
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

    private object ExceptionLogHandler {
        private val log = Companion.log ?: throw NullPointerException("ExceptionHandlerAdvice log variable is null")

        fun printLog(errorCode: ErrorCode, stackTrace: String) {
            val messageTemplate = "ErrorCode: ${errorCode.code}, Message: ${errorCode.message} StackTrace:$stackTrace"
            when (errorCode.logLevel) {
                Level.ERROR -> log.error(messageTemplate)
                Level.WARN -> log.warn(messageTemplate)
                Level.INFO -> log.info(messageTemplate)
                Level.DEBUG -> log.debug(messageTemplate)
                Level.TRACE -> log.trace(messageTemplate)
            }
        }
    }
}