package org.clonecoder.bookingserver.interfaces.mapper;

import org.clonecoder.bookingserver.domain.command.BookingGuestsCommand;
import org.clonecoder.bookingserver.interfaces.dto.BookingGuestsDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingGuestsDtoMapper {
    /**
     * BookingGuestsDto to BookingGuestsCommand
     * @param bookingGuestsDto
     * @return
     */
    public BookingGuestsCommand of(BookingGuestsDto bookingGuestsDto) {
        return new BookingGuestsCommand().toCommand(bookingGuestsDto);
    }

    /**
     * List<BookingGuestsDto> to List<BookingGuestsCommand>
     * @param bookingGuestsDtoLidt
     * @return
     */
    public List<BookingGuestsCommand> of(List<BookingGuestsDto> bookingGuestsDtoLidt) {
        return bookingGuestsDtoLidt.stream()
                .map(bookingGuestsDto -> new BookingGuestsCommand().toCommand(bookingGuestsDto))
                .collect(Collectors.toList());
    }
}
