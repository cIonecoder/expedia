package org.clonecoder.bookingserver.infrastructure;

import lombok.RequiredArgsConstructor;
import org.clonecoder.bookingserver.domain.Booking;
import org.clonecoder.bookingserver.domain.BookingGuests;
import org.clonecoder.bookingserver.domain.booking.BookingStore;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookingStoreImpl implements BookingStore {
    private final BookingRepository bookingRepository;
    private final BookingGuestsRepository bookingGuestsRepository;

    /**
     * 숙박 업체 저장
     * @param booking
     */
    public void saveBooking(Booking booking) {
        bookingRepository.save(booking);
    }

    /**
     * 숙박업체 권한 정보 저장
     * @param bookingGuests
     */
    public void saveBookingGuests(BookingGuests bookingGuests) {
        bookingGuestsRepository.save(bookingGuests);
    }
}
