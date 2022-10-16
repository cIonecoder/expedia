package org.clonecoder.bookingserver.domain.booking;

import lombok.RequiredArgsConstructor;
import org.clonecoder.bookingserver.domain.Booking;
import org.clonecoder.bookingserver.domain.BookingGuests;
import org.clonecoder.bookingserver.domain.command.BookingCommand;
import org.clonecoder.bookingserver.domain.command.BookingGuestsCommand;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService {
    private final BookingStore bookingStore;

    /**
     * 예약 저장
     * @param bookingCommand
     * @param bookingGuestsCommandList
     * @return
     */
    @Transactional
    public Booking saveBooking(BookingCommand bookingCommand, List<BookingGuestsCommand> bookingGuestsCommandList) {
        /* booking 저장 */
        Booking booking = bookingCommand.toEntity();
        Booking resultBooking = bookingStore.saveBooking(booking);

        /* booking guests List 저장 */
        List<BookingGuests> bookingGuestsList = new ArrayList<>();
        bookingGuestsCommandList.forEach(bookingGuestsCommand -> {
            BookingGuests bookingGuests = bookingGuestsCommand.toEntity();
            bookingGuests.settingBooking(resultBooking);
            bookingGuestsList.add(bookingGuests);
        });

        /* 예약 저장 */
        bookingStore.saveBookingGuests(bookingGuestsList);

        /* 예약건에 대한 재고 감소 */
        this.accommodationRoomStockDecrease(resultBooking.getAccommodationRoomId());

        return resultBooking;
    }

    /**
     * 숙박업체 룸 재고 감소
     * @param accommodationRoomId
     */
    public void accommodationRoomStockDecrease(final Long accommodationRoomId) {
        bookingStore.accommodationRoomStockDecrease(accommodationRoomId);
    }
}
