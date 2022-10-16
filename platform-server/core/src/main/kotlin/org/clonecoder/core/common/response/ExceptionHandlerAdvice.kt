package org.clonecoder.core.common.response

import org.apache.commons.lang3.exception.ExceptionUtils
import org.clonecoder.core.common.exception.DomainException
import org.clonecoder.core.common.exception.DuplicatedEmailException
import org.clonecoder.core.common.exception.InvalidTokenException
import org.clonecoder.core.common.exception.NotExistMemberException
import org.clonecoder.core.common.exception.RedisClientException
import org.clonecoder.core.common.exception.ValidationException
import org.slf4j.LoggerFactory
import org.slf4j.event.Level
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandlerAdvice {

    private val log = LoggerFactory.getLogger(this::class.java)

    @ExceptionHandler(NotExistMemberException::class)
    fun notExistMemberException(e: NotExistMemberException): ResponseEntity<CommonResponse<*>> {
        printLog(e.errorCode, ExceptionUtils.getStackTrace(e))
        return ResponseEntity
            .status(ErrorCode.BAD_REQUEST.status)
            .body(CommonResponse.fail(e.errorCode))
    }

    @ExceptionHandler(DuplicatedEmailException::class)
    fun duplicatedEmailException(e: DuplicatedEmailException): ResponseEntity<CommonResponse<*>> {
        printLog(e.errorCode, ExceptionUtils.getStackTrace(e))
        return ResponseEntity
            .status(ErrorCode.BAD_REQUEST.status)
            .body(CommonResponse.fail(e.errorCode))
    }

    @ExceptionHandler(RedisClientException::class)
    fun redisClientException(e: RedisClientException): ResponseEntity<CommonResponse<*>> {
        printLog(e.errorCode, ExceptionUtils.getStackTrace(e))
        return ResponseEntity
            .status(ErrorCode.BAD_REQUEST.status)
            .body(CommonResponse.fail(e.errorCode))
    }

    @ExceptionHandler(InvalidTokenException::class)
    fun invalidTokenException(e: InvalidTokenException): ResponseEntity<CommonResponse<*>> {
        printLog(e.errorCode, ExceptionUtils.getStackTrace(e))
        return ResponseEntity
            .status(e.errorCode.status)
            .body(CommonResponse.fail(e.errorCode))
    }

    @ExceptionHandler(ValidationException::class)
    fun validationException(e: ValidationException): ResponseEntity<CommonResponse<*>> {
        printLog(e.errorCode, ExceptionUtils.getStackTrace(e))
        return ResponseEntity
            .status(ErrorCode.VALIDATION.status)
            .body(CommonResponse.fail(ErrorCode.VALIDATION, e.errors))
    }

    @ExceptionHandler(DomainException::class)
    fun domainException(e: DomainException): ResponseEntity<CommonResponse<*>> {
        printLog(e.errorCode, ExceptionUtils.getStackTrace(e))
        return ResponseEntity
            .status(ErrorCode.INTERNAL_SERVER_ERROR.status)
            .body(CommonResponse.fail(ErrorCode.INTERNAL_SERVER_ERROR))
    }

    @ExceptionHandler(Exception::class)
    fun exception(e: Exception): ResponseEntity<CommonResponse<*>> {
        log.error("Not Defined or Not Handled Exception occur", e)
        return ResponseEntity
            .status(ErrorCode.INTERNAL_SERVER_ERROR.status)
            .body(CommonResponse.fail(ErrorCode.INTERNAL_SERVER_ERROR))
    }

    private fun printLog(errorCode: ErrorCode, stackTrace: String) {
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