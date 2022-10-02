package org.clonecoder.bookingserver.application.booking;

import lombok.RequiredArgsConstructor;
import org.clonecoder.bookingserver.domain.Booking;
import org.clonecoder.bookingserver.domain.command.BookingCommand;
import org.clonecoder.bookingserver.domain.BookingGuests;
import org.clonecoder.bookingserver.domain.command.BookingGuestsCommand;
import org.clonecoder.bookingserver.domain.booking.BookingService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingFacade {
    private final BookingService bookingService;

    /**
     * 예약 저장
     * @param bookingCommand
     * @param bookingGuestsCommandList
     * @return
     */
    public Long saveBooking(BookingCommand bookingCommand, List<BookingGuestsCommand> bookingGuestsCommandList) {
        /* booking 저장 */
        Booking booking = bookingCommand.toEntity();

        Booking resultBooking = bookingService.saveBooking(booking);

        /* booking guests List 저장 */
        List<BookingGuests> bookingGuestsList = new ArrayList<>();
        bookingGuestsCommandList.forEach(bookingGuestsCommand -> {
            BookingGuests bookingGuests = bookingGuestsCommand.toEntity();
            bookingGuests.settingBooking(bookingGuests, resultBooking);
            bookingGuestsList.add(bookingGuests);
        });

        bookingService.saveBookingGuests(bookingGuestsList);

        return resultBooking.getId();
    }
}
