package org.clonecoder.bookingserver.common.enums;

import lombok.Getter;

public enum EnumMessage {
    HTTP_SUCCESS      ("성공"),
    NOT_EXIST_BOOKING ("존재하지않은 예약건입니다.")
    ;

    @Getter
    private final String message;

    EnumMessage(String message) {
        this.message = message;
    }
}
