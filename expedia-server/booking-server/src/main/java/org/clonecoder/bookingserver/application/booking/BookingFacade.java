package org.clonecoder.bookingserver.application.booking;

import lombok.RequiredArgsConstructor;
import org.clonecoder.bookingserver.domain.Booking;
import org.clonecoder.bookingserver.domain.BookingGuests;
import org.clonecoder.bookingserver.domain.booking.BookingService;
import org.clonecoder.bookingserver.domain.command.BookingCommand;
import org.clonecoder.bookingserver.domain.command.BookingGuestsCommand;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class BookingFacade {
    private final BookingService bookingService;

    /**
     * 예약 저장
     * @param bookingCommand
     * @param bookingGuestsCommandList
     * @return
     */
    @Transactional
    public Long saveBooking(BookingCommand bookingCommand, List<BookingGuestsCommand> bookingGuestsCommandList) {
        /* booking 저장 */
        Booking booking = bookingCommand.toEntity();

        Booking resultBooking = bookingService.saveBooking(booking);

        /* booking guests List 저장 */
        List<BookingGuests> bookingGuestsList = new ArrayList<>();
        bookingGuestsCommandList.forEach(bookingGuestsCommand -> {
            BookingGuests bookingGuests = bookingGuestsCommand.toEntity();
            bookingGuests.settingBooking(resultBooking);
            bookingGuestsList.add(bookingGuests);
        });

        bookingService.saveBookingGuests(bookingGuestsList);

        return resultBooking.getId();
    }
}