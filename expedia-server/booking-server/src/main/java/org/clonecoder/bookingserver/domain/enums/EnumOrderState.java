package org.clonecoder.bookingserver.domain.enums;

import lombok.Getter;

public enum EnumOrderState {
    ORDER_CREATED  ("예약생성"),
    PAYMENT_REQUEST ("결제요청"),
    ORDER_COMPLETED ("예약완료")
    ;

    @Getter
    private final String state;

    EnumOrderState(String state) {
        this.state = state;
    }
}
