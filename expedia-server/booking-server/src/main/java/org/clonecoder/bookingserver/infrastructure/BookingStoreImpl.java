package org.clonecoder.bookingserver.infrastructure;

import lombok.RequiredArgsConstructor;
import org.clonecoder.bookingserver.domain.Booking;
import org.clonecoder.bookingserver.domain.BookingGuests;
import org.clonecoder.bookingserver.domain.booking.BookingStore;
import org.clonecoder.productserver.domain.accommodation.AccommodationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingStoreImpl implements BookingStore {
    private final BookingRepository bookingRepository;
    private final BookingGuestsRepository bookingGuestsRepository;
    private final AccommodationService accommodationService;

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

    /**
     * 예약건에 대한 재고 설정
     * @param accommodationRoomId
     */
    public void accommodationRoomStockDecrease(Long accommodationRoomId) {
        accommodationService.stockDecrease(accommodationRoomId);
    }
}
