package org.clonecoder.auth.common.response

import org.slf4j.event.Level
import org.springframework.http.HttpStatus


enum class ErrorCode(
    val status: HttpStatus,
    val code: String,
    val message: String,
    val logLevel: Level = Level.INFO
) {
    // Well known Errors
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "W1004", "Bad Request", Level.ERROR),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "W1005", "Internal Server Error", Level.ERROR),

    // Custom Errors
    VALIDATION(HttpStatus.BAD_REQUEST, "C1001", "Validation Error"),
    INVALID_TOKEN(HttpStatus.BAD_REQUEST, "C1002", "Invalid Token"),
    INVALID_ACCESS_TOKEN(HttpStatus.BAD_REQUEST, "C1003", "Invalid Access Token"),
    INVALID_REFRESH_TOKEN(HttpStatus.BAD_REQUEST, "C1004", "Invalid Refresh Token"),
    REDIS_CLIENT(HttpStatus.BAD_REQUEST, "C1005", "Redis Client Error", Level.ERROR),

    // Hierarchy
    DOMAIN(HttpStatus.BAD_REQUEST, "H1001", "Domain Layer Error"),
    ;
}