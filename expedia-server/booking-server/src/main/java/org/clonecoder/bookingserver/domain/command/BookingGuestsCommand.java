package org.clonecoder.bookingserver.domain.command;

import lombok.Getter;
import lombok.Setter;
import org.clonecoder.bookingserver.domain.Booking;
import org.clonecoder.bookingserver.domain.BookingGuests;
import org.clonecoder.bookingserver.interfaces.dto.BookingGuestsDto;
import org.springframework.stereotype.Service;

@Service
public class BookingGuestsCommand {
    @Getter
    @Setter
    private BookingGuestsDto bookingGuestsDto;

    public BookingGuestsCommand toCommand(BookingGuestsDto bookingGuestsDto) {
        BookingGuestsCommand bookingGuestsCommand = new BookingGuestsCommand();
        bookingGuestsCommand.setBookingGuestsDto(bookingGuestsDto);

        return bookingGuestsCommand;
    }

    public BookingGuests toEntity() {
        return new BookingGuests(bookingGuestsDto);
    }
}
