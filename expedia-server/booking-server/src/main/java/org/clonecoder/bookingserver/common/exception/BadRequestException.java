package org.clonecoder.bookingserver.common.exception;

import lombok.Getter;
import org.clonecoder.bookingserver.common.enums.ExceptionMessage;

public class BadRequestException extends RuntimeException {
    @Getter
    private final ExceptionMessage exceptionMessage;

    public BadRequestException(ExceptionMessage exceptionMessage) {
        super(exceptionMessage.getMessage());
        this.exceptionMessage = exceptionMessage;
    }
}
