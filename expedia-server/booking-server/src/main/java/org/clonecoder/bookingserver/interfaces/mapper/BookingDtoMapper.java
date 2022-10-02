package org.clonecoder.bookingserver.interfaces.mapper;

import org.clonecoder.bookingserver.domain.command.BookingCommand;
import org.clonecoder.bookingserver.interfaces.dto.BookingDto;
import org.springframework.stereotype.Service;

@Service
public class BookingDtoMapper {
    /**
     * BookingDto to BookingCommand
     * @param bookingDto
     * @return
     */
    public BookingCommand of(BookingDto bookingDto) {
        return new BookingCommand().toCommand(bookingDto);
    }
}
