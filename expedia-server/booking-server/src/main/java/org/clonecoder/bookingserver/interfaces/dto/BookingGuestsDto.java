package org.clonecoder.bookingserver.interfaces.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.clonecoder.bookingserver.domain.enums.EnumGuestType;
import org.clonecoder.bookingserver.domain.command.BookingGuestsCommand;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookingGuestsDto extends BaseDto {
    private Long id;
    private Long bookingId;
    private EnumGuestType enumGuestType;
    private String guestLastName;
    private String guestFirstName;
    private String guestHpno;
    private String guestEmail;
    private int guestAge;
    private BigDecimal guestFee;

    public BookingGuestsCommand toCommand() {
        BookingGuestsCommand bookingGuestsCommand = new BookingGuestsCommand();
        bookingGuestsCommand.setBookingId(this.bookingId);
        bookingGuestsCommand.setEnumGuestType(this.enumGuestType);
        bookingGuestsCommand.setGuestLastName(this.guestLastName);
        bookingGuestsCommand.setGuestFirstName(this.guestFirstName);
        bookingGuestsCommand.setGuestHpno(this.guestHpno);
        bookingGuestsCommand.setGuestEmail(this.guestEmail);
        bookingGuestsCommand.setGuestAge(this.guestAge);
        bookingGuestsCommand.setGuestFee(this.guestFee);
        bookingGuestsCommand.setCreatedBy(this.getCreatedBy());
        bookingGuestsCommand.setLastModifiedBy(this.getLastModifiedBy());

        return bookingGuestsCommand;
    }
}
