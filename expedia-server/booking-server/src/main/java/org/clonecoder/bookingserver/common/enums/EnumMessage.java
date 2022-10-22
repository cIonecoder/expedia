package org.clonecoder.bookingserver.common.enums;

import lombok.Getter;

public enum EnumMessage {
    OK                          (0, ""),
    HTTP_INTERNAL_SERVER_ERROR  (5001, "서버에러가 발생하여 요청사항을 수행할 수 없습니다."),

    HTTP_BAD_REQUEST            (4001, "요청이 잘못되었습니다."),
    NOT_EXIST_BOOKING           (4002, "존재하지않은 예약건입니다.")
    ;

    @Getter
    private int code;

    @Getter
    private final String message;

    EnumMessage(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
