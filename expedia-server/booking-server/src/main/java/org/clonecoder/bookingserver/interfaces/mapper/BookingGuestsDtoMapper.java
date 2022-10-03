package org.clonecoder.bookingserver.interfaces.mapper;

import org.clonecoder.bookingserver.domain.command.BookingGuestsCommand;
import org.clonecoder.bookingserver.interfaces.dto.BookingGuestsDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookingGuestsDtoMapper {
    /**
     * List<BookingGuestsDto> to List<BookingGuestsCommand>
     * @param bookingGuestsDtoLidt
     * @return
     */
    public List<BookingGuestsCommand> of(List<BookingGuestsDto> bookingGuestsDtoLidt) {
        return bookingGuestsDtoLidt.stream()
                .map(BookingGuestsDto::toCommand)
                .collect(Collectors.toList());
    }
}
