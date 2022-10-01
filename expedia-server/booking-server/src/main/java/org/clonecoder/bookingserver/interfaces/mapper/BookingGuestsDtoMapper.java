package org.clonecoder.bookingserver.interfaces.mapper;

import org.clonecoder.bookingserver.domain.command.BookingGuestsCommand;
import org.clonecoder.bookingserver.interfaces.dto.BookingGuestsDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookingGuestsDtoMapper {
    public BookingGuestsCommand of(BookingGuestsDto bookingGuestsDto) {
        return new BookingGuestsCommand();
    }

    public List<BookingGuestsCommand> of(List<BookingGuestsDto> bookingGuestsDto) {
        return new ArrayList<BookingGuestsCommand>();
    }
}
