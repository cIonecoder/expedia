package org.clonecoder.productserver.common.exception;

import lombok.Getter;
import org.clonecoder.productserver.common.enums.ExceptionMessage;

public class BadRequestException extends RuntimeException {
    @Getter
    private final ExceptionMessage exceptionMessage;

    public BadRequestException(ExceptionMessage exceptionMessage) {
        super(exceptionMessage.getMessage());
        this.exceptionMessage = exceptionMessage;
    }
}
