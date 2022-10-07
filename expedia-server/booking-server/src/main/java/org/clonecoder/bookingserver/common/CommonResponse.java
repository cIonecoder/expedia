package org.clonecoder.bookingserver.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CommonResponse {
    public static <T> ResponseEntity<ResponseDto<T>> send(T body, HttpStatus status, String message) {
        ResponseDto<T> responseDto = ResponseDto.<T>builder()
                .status(status.value())
                .message(message)
                .body(body)
                .build();

        return ResponseEntity.status(status).body(responseDto);
    }

    public static ResponseEntity<?> send() {
        return CommonResponse.send(null, HttpStatus.OK, "");
    }

    public static <T> ResponseEntity<ResponseDto<T>> send(T object) {
        return CommonResponse.send(object, HttpStatus.OK, "");
    }
}