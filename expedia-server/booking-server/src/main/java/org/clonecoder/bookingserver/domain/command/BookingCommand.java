package org.clonecoder.bookingserver.domain.command;

import org.clonecoder.bookingserver.domain.Booking;
import org.springframework.stereotype.Service;

@Service
public class BookingCommand {
    public Booking toEntity() {
        return new Booking();
    }
}
