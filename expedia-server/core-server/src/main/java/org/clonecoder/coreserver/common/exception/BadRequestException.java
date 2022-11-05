package org.clonecoder.coreserver.common.exception;

import lombok.Getter;
import org.clonecoder.coreserver.common.enums.ExceptionMessage;

public class BadRequestException extends RuntimeException {
    @Getter
    private final ExceptionMessage exceptionMessage;

    public BadRequestException(ExceptionMessage exceptionMessage) {
        super(exceptionMessage.getMessage());
        this.exceptionMessage = exceptionMessage;
    }
}
