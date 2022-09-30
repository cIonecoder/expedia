package org.clonecoder.bookingserver.interfaces.controller;

import lombok.RequiredArgsConstructor;
import org.clonecoder.bookingserver.application.booking.BookingFacade;
import org.clonecoder.bookingserver.interfaces.dto.RequestSaveBookingDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/booking")
public class BookingController {
    private final BookingFacade bookingFacade;

    @PostMapping("")
    public String saveBooking(@RequestBody RequestSaveBookingDto requestSaveBookingDto) {
        return "";
    }
}
