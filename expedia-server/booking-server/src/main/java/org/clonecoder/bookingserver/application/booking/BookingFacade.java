package org.clonecoder.bookingserver.application.booking;

import lombok.RequiredArgsConstructor;
import org.clonecoder.bookingserver.domain.Booking;
import org.clonecoder.bookingserver.domain.BookingGuests;
import org.clonecoder.bookingserver.domain.booking.BookingService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookingFacade {
    private final BookingService bookingService;

    /**
     * 예약 저장
     * @param booking
     */
    public void saveBooking(Booking booking) {
        bookingService.saveBooking(booking);
    }

    /**
     * 예약 게스트 저장
     * @param bookingGuests
     */
    public void saveBookingGuests(BookingGuests bookingGuests) {
        bookingService.saveBookingGuests(bookingGuests);
    }
}
