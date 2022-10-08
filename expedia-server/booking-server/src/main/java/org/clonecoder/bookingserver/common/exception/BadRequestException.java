package org.clonecoder.bookingserver.common.exception;

import org.clonecoder.bookingserver.common.enums.EnumMessage;

public class BadRequestException extends RuntimeException {
    private String message;

    public BadRequestException(String message) {
        super(message);
        this.message = message;
    }

    public BadRequestException(EnumMessage enumMessage) {
        super(enumMessage.getMessage());
        this.message = enumMessage.getMessage();
    }
}
