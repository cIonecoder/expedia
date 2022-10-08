package org.clonecoder.bookingserver.interfaces.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseDto<T> {
    private int status;
    private String message;
    private T data;
}
