package org.clonecoder.bookingserver.domain.command;

import org.clonecoder.bookingserver.domain.BookingGuests;
import org.springframework.stereotype.Service;

@Service
public class BookingGuestsCommand {
    public BookingGuests toEntity() {
        return new BookingGuests();
    }

    public BookingGuests toEntity(Long bookingId) {
        return new BookingGuests();
    }
}
