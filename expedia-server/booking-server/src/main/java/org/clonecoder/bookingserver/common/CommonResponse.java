package org.clonecoder.bookingserver.common;

import org.clonecoder.bookingserver.common.enums.EnumMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;

public class CommonResponse {
    public static <T> ResponseEntity<ResponseDto<T>> send(HttpStatus status, EnumMessage enumMessage, T body) {
        ResponseDto<T> responseDto = ResponseDto.<T>builder()
                .status(enumMessage.getCode())
                .message(enumMessage.getMessage())
                .body(body)
                .build();

        return ResponseEntity.status(status.value()).body(responseDto);
    }

    public static ResponseEntity<?> send() {
        return CommonResponse.send(HttpStatus.OK, EnumMessage.OK, "");
    }

    public static <T> ResponseEntity<ResponseDto<T>> send(T object) {
        return CommonResponse.send(HttpStatus.OK, EnumMessage.OK, object);
    }
}