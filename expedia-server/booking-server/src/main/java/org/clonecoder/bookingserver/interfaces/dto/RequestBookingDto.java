package org.clonecoder.bookingserver.interfaces.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

public class RequestBookingDto {
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class saveDto {
        private BookingDto bookingDto;
        private List<BookingGuestsDto> bookingGuestsDtoList;
    }
}
