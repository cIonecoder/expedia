package org.clonecoder.bookingserver.interfaces.controller;

import lombok.RequiredArgsConstructor;
import org.clonecoder.bookingserver.application.booking.BookingFacade;
import org.clonecoder.bookingserver.domain.command.BookingCommand;
import org.clonecoder.bookingserver.domain.command.BookingGuestsCommand;
import org.clonecoder.bookingserver.interfaces.dto.RequestSaveBookingDto;
import org.clonecoder.bookingserver.interfaces.mapper.BookingDtoMapper;
import org.clonecoder.bookingserver.interfaces.mapper.BookingGuestsDtoMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/booking")
public class BookingController {
    private final BookingFacade bookingFacade;
    private final BookingDtoMapper bookingDtoMapper;
    private final BookingGuestsDtoMapper bookingGuestsDtoMapper;

    @PostMapping("")
    public Long saveBooking(@RequestBody RequestSaveBookingDto requestSaveBookingDto) {
        /* to command */
        BookingCommand bookingCommand = bookingDtoMapper.of(requestSaveBookingDto.getBooking());
        List<BookingGuestsCommand> bookingGuestsCommandList = bookingGuestsDtoMapper.of(requestSaveBookingDto.getBookingGuests());

        return bookingFacade.saveBooking(bookingCommand, bookingGuestsCommandList);
    }
}
