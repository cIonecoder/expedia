package org.clonecoder.bookingserver.interfaces.mapper;

import org.clonecoder.bookingserver.domain.command.BookingGuestsCommand;
import org.clonecoder.bookingserver.interfaces.dto.BookingGuestsDto;

import java.util.List;
import java.util.stream.Collectors;

public class BookingGuestsDtoMapper {
    /**
     * List<BookingGuestsDto> to List<BookingGuestsCommand>
     * @param bookingGuestsDtoLidt
     * @return
     */
    public static List<BookingGuestsCommand> of(List<BookingGuestsDto> bookingGuestsDtoLidt) {
        return bookingGuestsDtoLidt.stream()
                .map(BookingGuestsDto::toCommand)
                .collect(Collectors.toList());
    }
}
