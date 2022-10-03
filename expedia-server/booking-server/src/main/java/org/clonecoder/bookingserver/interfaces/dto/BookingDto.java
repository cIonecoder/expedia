package org.clonecoder.bookingserver.interfaces.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.clonecoder.bookingserver.domain.enums.EnumOrderState;
import org.clonecoder.bookingserver.domain.command.BookingCommand;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookingDto extends BaseDto {
    private Long id;
    private String bookingNo;
    private Long accommodationRoomId;
    private String bookingUserId;
    private String bookingLastName;
    private String bookingFirstName;
    private String bookingHpno;
    private String bookingEmail;
    private LocalDateTime checkinStartDateTime;
    private LocalDateTime checkinEndDateTime;
    private BigDecimal bookingTotalFee;
    private EnumOrderState enumOrderState;

    public BookingCommand toCommand() {
        BookingCommand bookingCommand = new BookingCommand();
        bookingCommand.setBookingNo(this.bookingNo);
        bookingCommand.setAccommodationRoomId(this.accommodationRoomId);
        bookingCommand.setBookingUserId(this.bookingUserId);
        bookingCommand.setBookingLastName(this.bookingLastName);
        bookingCommand.setBookingFirstName(this.bookingFirstName);
        bookingCommand.setBookingHpno(this.bookingHpno);
        bookingCommand.setBookingEmail(this.bookingEmail);
        bookingCommand.setCheckinStartDateTime(this.checkinStartDateTime);
        bookingCommand.setCheckinEndDateTime(this.checkinEndDateTime);
        bookingCommand.setBookingTotalFee(this.bookingTotalFee);
        bookingCommand.setEnumOrderState(this.enumOrderState);
        bookingCommand.setLastModifiedBy(this.getLastModifiedBy());
        bookingCommand.setCreatedBy(this.getCreatedBy());

        return bookingCommand;
    }
}
