package org.clonecoder.core.common.response

import org.apache.commons.lang3.exception.ExceptionUtils
import org.clonecoder.core.common.exception.ConvertException
import org.clonecoder.core.common.exception.DomainException
import org.clonecoder.core.common.exception.ValidationException
import org.slf4j.LoggerFactory
import org.slf4j.event.Level
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandlerAdvice {

    private val log = LoggerFactory.getLogger(this::class.java)

    @ExceptionHandler(ConvertException::class)
    fun convertException(e: ConvertException): ResponseEntity<CommonResponse<*>> {
        printLog(e.errorCode, ExceptionUtils.getStackTrace(e))
        return ResponseEntity
            .status(e.errorCode.status)
            .body(CommonResponse.fail(e.errorCode))
    }

    @ExceptionHandler(ValidationException::class)
    fun validationException(e: ValidationException): ResponseEntity<CommonResponse<*>> {
        printLog(e.errorCode, ExceptionUtils.getStackTrace(e))
        return ResponseEntity
            .status(e.errorCode.status)
            .body(CommonResponse.fail(e.errorCode, e.errors))
    }

    @ExceptionHandler(DomainException::class)
    fun domainException(e: DomainException): ResponseEntity<*> {
        printLog(e.errorCode, ExceptionUtils.getStackTrace(e))
        return ResponseEntity
            .status(e.errorCode.status)
            .body(CommonResponse.fail(e.errorCode))
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