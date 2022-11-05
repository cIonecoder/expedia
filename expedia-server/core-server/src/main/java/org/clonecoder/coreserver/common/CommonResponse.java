package org.clonecoder.coreserver.common;

import org.clonecoder.coreserver.common.enums.ExceptionMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CommonResponse {
    public static <T> ResponseEntity<ResponseDto<T>> send(HttpStatus status, ExceptionMessage exceptionMessage, T body) {
        ResponseDto<T> responseDto = ResponseDto.<T>builder()
                .status(exceptionMessage.getCode())
                .message(exceptionMessage.getMessage())
                .body(body)
                .build();

        return ResponseEntity.status(status.value()).body(responseDto);
    }

    public static ResponseEntity<?> send() {
        return CommonResponse.send(HttpStatus.OK, ExceptionMessage.OK, "");
    }

    public static <T> ResponseEntity<ResponseDto<T>> send(T object) {
        return CommonResponse.send(HttpStatus.OK, ExceptionMessage.OK, object);
    }
}