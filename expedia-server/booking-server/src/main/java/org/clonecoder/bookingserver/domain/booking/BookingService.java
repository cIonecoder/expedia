package org.clonecoder.bookingserver.domain.booking;

import lombok.RequiredArgsConstructor;
import org.clonecoder.bookingserver.domain.Booking;
import org.clonecoder.bookingserver.domain.BookingGuests;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookingService {
    private final BookingStore bookingStore;

    /**
     * 예약 저장
     * @param booking
     */
    public void saveBooking(Booking booking) {
        bookingStore.saveBooking(booking);
    }

    /**
     * 예약 게스트 저장
     * @param bookingGuests
     */
    public void saveBookingGuests(BookingGuests bookingGuests) {
        bookingStore.saveBookingGuests(bookingGuests);
    }
}
