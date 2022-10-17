package org.clonecoder.bookingserver.infrastructure;

import lombok.RequiredArgsConstructor;
import org.clonecoder.bookingserver.domain.Booking;
import org.clonecoder.bookingserver.domain.BookingGuests;
import org.clonecoder.bookingserver.domain.booking.BookingStore;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingStoreImpl implements BookingStore {
    private final BookingRepository bookingRepository;
    private final BookingGuestsRepository bookingGuestsRepository;

    /**
     * 예약 저장
     * @param booking
     */
    public Booking saveBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    /**
     * 예약 게스트 정보 저장
     * @param bookingGuests
     */
    public void saveBookingGuests(List<BookingGuests> bookingGuests) {
        bookingGuestsRepository.saveAll(bookingGuests);
    }
}
