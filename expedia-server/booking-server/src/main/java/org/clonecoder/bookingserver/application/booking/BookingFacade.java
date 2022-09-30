package org.clonecoder.bookingserver.application.booking;

import lombok.RequiredArgsConstructor;
import org.clonecoder.bookingserver.domain.Booking;
import org.clonecoder.bookingserver.domain.BookingCommand;
import org.clonecoder.bookingserver.domain.BookingGuests;
import org.clonecoder.bookingserver.domain.booking.BookingService;
import org.clonecoder.bookingserver.interfaces.dto.BookingGuestsDto;
import org.clonecoder.bookingserver.interfaces.dto.RequestSaveBookingDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingFacade {
    private final BookingService bookingService;
    private final BookingCommand bookingCommand;

    /**
     * 예약 저장
     * @param requestSaveBookingDto
     */
    public Long saveBooking(RequestSaveBookingDto requestSaveBookingDto) {
        Booking booking = bookingCommand.toBookingEntity(requestSaveBookingDto.getBooking());
        Long bookingId = bookingService.saveBooking(booking).getId();

        List<BookingGuests> bookingGuestsList = new ArrayList<>();
        requestSaveBookingDto.getBookingGuests().forEach(bookingGuestsDto -> {
            bookingGuestsDto.setBookingId(bookingId);
            bookingGuestsList.add(bookingCommand.toBookingGuestsEntity(bookingGuestsDto));
        });

        bookingService.saveBookingGuests(bookingGuestsList);

        return bookingId;
    }
}
