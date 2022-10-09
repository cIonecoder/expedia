package org.clonecoder.auth.common.response

import org.springframework.http.HttpStatus


enum class ErrorCode(
    val status: HttpStatus,
    val code: String,
    val message: String,
) {
    // Well known Errors
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "-1004", "Bad Request"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "-1005", "Internal Server Error"),


    // Custom Errors
    INVALID_TOKEN(HttpStatus.BAD_REQUEST, "-2001", "Invalid Token"),

    ;
}