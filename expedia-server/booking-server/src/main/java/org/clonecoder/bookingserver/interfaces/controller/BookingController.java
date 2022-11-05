package org.clonecoder.bookingserver.interfaces.controller;

import lombok.RequiredArgsConstructor;
import org.clonecoder.bookingserver.application.booking.BookingFacade;
import org.clonecoder.bookingserver.domain.command.BookingCommand;
import org.clonecoder.bookingserver.domain.command.BookingGuestsCommand;
import org.clonecoder.bookingserver.interfaces.dto.RequestBookingDto;
import org.clonecoder.bookingserver.interfaces.mapper.BookingDtoMapper;
import org.clonecoder.bookingserver.interfaces.mapper.BookingGuestsDtoMapper;
import org.clonecoder.coreserver.common.CommonResponse;
import org.clonecoder.coreserver.common.ResponseDto;
import org.springframework.http.ResponseEntity;
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

    @PostMapping
    public ResponseEntity<ResponseDto<Long>> saveBooking(@RequestBody RequestBookingDto.saveDto requestSaveDto) {
        /* to command */
        BookingCommand bookingCommand = BookingDtoMapper.of(requestSaveDto.getBookingDto());
        List<BookingGuestsCommand> bookingGuestsCommandList = BookingGuestsDtoMapper.of(requestSaveDto.getBookingGuestsDtoList());

        /* save Booking */
        Long idx = bookingFacade.saveBooking(bookingCommand, bookingGuestsCommandList);

        return CommonResponse.send(idx);
    }
}
