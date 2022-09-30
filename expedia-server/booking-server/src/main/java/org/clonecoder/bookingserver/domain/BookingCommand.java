package org.clonecoder.bookingserver.domain;

import lombok.RequiredArgsConstructor;
import org.clonecoder.bookingserver.interfaces.dto.BookingDto;
import org.clonecoder.bookingserver.interfaces.dto.BookingGuestsDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookingCommand {
    private final ModelMapper modelMapper;

    public Booking toBookingEntity(BookingDto bookingDto) {
        return modelMapper.map(bookingDto, Booking.class);
    }

    public BookingGuests toBookingGuestsEntity(BookingGuestsDto bookingGuestsDto) {
        return modelMapper.map(bookingGuestsDto, BookingGuests.class);
    }
}
