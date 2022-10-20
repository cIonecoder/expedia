package org.clonecoder.bookingserver.domain.booking;

import org.clonecoder.bookingserver.domain.Booking;
import org.clonecoder.bookingserver.domain.BookingGuests;

import java.util.List;

/**
 * Adapter Service
 */
public interface BookingStore {
    Booking saveBooking(Booking booking);
    void saveBookingGuests(List<BookingGuests> bookingGuests);
}
