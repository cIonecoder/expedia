package org.clonecoder.bookingserver.domain.booking;

import org.clonecoder.bookingserver.domain.Booking;
import org.clonecoder.bookingserver.domain.BookingGuests;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Adapter Service
 */
public interface BookingStore {
    Booking saveBooking(Booking booking);
    void saveBookingGuests(List<BookingGuests> bookingGuests);
}
