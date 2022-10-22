package org.clonecoder.bookingserver.common.exception;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.clonecoder.bookingserver.common.CommonResponse;
import org.clonecoder.bookingserver.common.enums.EnumMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
@RequiredArgsConstructor
public class CommonExceptionHandler {
    /**
     * 400 에러
     * @param e
     * @return
     */
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> error400(BadRequestException e) {
        return CommonResponse.send(HttpStatus.BAD_REQUEST, e.getEnumMessage(), null);
    }

    /**
     * 500 에러
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> error500(Exception e) {
        e.printStackTrace();
        return CommonResponse.send(HttpStatus.INTERNAL_SERVER_ERROR, EnumMessage.HTTP_INTERNAL_SERVER_ERROR, null);
    }
}