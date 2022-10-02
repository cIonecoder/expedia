package org.clonecoder.bookingserver.domain.command;

import lombok.Getter;
import lombok.Setter;
import org.clonecoder.bookingserver.domain.Booking;
import org.clonecoder.bookingserver.interfaces.dto.BookingDto;
import org.springframework.stereotype.Service;

@Service
public class BookingCommand {
    @Setter
    @Getter
    private BookingDto bookingDto;

    public BookingCommand toCommand(BookingDto bookingDto) {
        BookingCommand bookingCommand = new BookingCommand();
        bookingCommand.setBookingDto(bookingDto);

        return bookingCommand;
    }

    public Booking toEntity() {
        return new Booking(bookingDto);
    }
}
