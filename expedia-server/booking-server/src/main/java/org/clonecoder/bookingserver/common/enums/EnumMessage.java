package org.clonecoder.bookingserver.common.enums;

import lombok.Getter;

public enum EnumMessage {
    /** HTTP_STATUS message */
    HTTP_SUCCESS                ("성공"),
    ;

    @Getter
    private final String message;

    EnumMessage(String message) {
        this.message = message;
    }
}
