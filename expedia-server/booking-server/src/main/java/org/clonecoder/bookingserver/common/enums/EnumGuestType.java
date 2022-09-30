package org.clonecoder.bookingserver.common.enums;

import lombok.Getter;

public enum EnumGuestType {
    ADULT  ("성인"),
    IDOL ("청소년"),
    CHILD ("유아")
    ;

    @Getter
    private final String type;

    EnumGuestType(String type) {
        this.type = type;
    }
}
