package org.clonecoder.bookingserver.domain;

import org.clonecoder.bookingserver.interfaces.dto.BookingDto;
import org.clonecoder.bookingserver.interfaces.dto.BookingGuestsDto;
import org.springframework.stereotype.Service;

@Service
public class BookingCommand {
    public Booking toBookingEntity(BookingDto bookingDto) {
        return new Booking();
    }

    public BookingGuests toBookingGuestsEntity(BookingGuestsDto bookingGuestsDto) {
        return new BookingGuests();
    }
}
