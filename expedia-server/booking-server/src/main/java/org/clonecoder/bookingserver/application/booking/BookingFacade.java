package org.clonecoder.bookingserver.application.booking;

import lombok.RequiredArgsConstructor;
import org.clonecoder.bookingserver.domain.Booking;
import org.clonecoder.bookingserver.domain.booking.BookingService;
import org.clonecoder.bookingserver.domain.command.BookingCommand;
import org.clonecoder.bookingserver.domain.command.BookingGuestsCommand;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
        /* 예약 등록 */
        Booking resultBooking = bookingService.saveBooking(bookingCommand, bookingGuestsCommandList);

        return resultBooking.getId();
    }
}
