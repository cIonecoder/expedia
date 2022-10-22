package org.clonecoder.bookingserver.common.exception;

import lombok.Getter;
import org.clonecoder.bookingserver.common.enums.EnumMessage;

public class BadRequestException extends RuntimeException {
    @Getter
    private final EnumMessage enumMessage;

    public BadRequestException(EnumMessage enumMessage) {
        super(enumMessage.getMessage());
        this.enumMessage = enumMessage;
    }
}
