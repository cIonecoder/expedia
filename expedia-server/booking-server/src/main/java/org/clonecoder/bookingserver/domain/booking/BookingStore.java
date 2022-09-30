package org.clonecoder.bookingserver.domain.booking;

import org.clonecoder.bookingserver.domain.Booking;
import org.clonecoder.bookingserver.domain.BookingGuests;
import org.springframework.stereotype.Service;

/**
 * Adapter Service
 */
@Service
public interface BookingStore {
    void saveBooking(Booking booking);
    void saveBookingGuests(BookingGuests bookingGuests);
}
