package org.clonecoder.bookingserver.interfaces.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestSaveBookingDto {
    private BookingDto bookingDto;
    private List<BookingGuestsDto> bookingGuestsDto;
}
