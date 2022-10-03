package org.clonecoder.bookingserver.interfaces.mapper;

import org.clonecoder.bookingserver.domain.command.BookingCommand;
import org.clonecoder.bookingserver.interfaces.dto.BookingDto;

public class BookingDtoMapper {
    /**
     * BookingDto to BookingCommand
     * @param bookingDto
     * @return
     */
    public static BookingCommand of(BookingDto bookingDto) {
        return bookingDto.toCommand();
    }
}
