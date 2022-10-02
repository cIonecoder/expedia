package org.clonecoder.bookingserver.interfaces.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.clonecoder.bookingserver.common.enums.EnumOrderState;
import org.clonecoder.bookingserver.domain.Booking;
import org.clonecoder.bookingserver.domain.command.BookingCommand;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookingDto {
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
    private String lastModifiedBy;
    private LocalDateTime lastModified;
    private String createdBy;
    private LocalDateTime createdAt;

    public BookingCommand toCommand() {
        BookingCommand bookingCommand = new BookingCommand();
        bookingCommand.setBookingNo(this.getBookingNo());
        bookingCommand.setAccommodationRoomId(this.getAccommodationRoomId());
        bookingCommand.setBookingUserId(this.getBookingUserId());
        bookingCommand.setBookingLastName(this.getBookingLastName());
        bookingCommand.setBookingFirstName(this.getBookingFirstName());
        bookingCommand.setBookingHpno(this.getBookingHpno());
        bookingCommand.setBookingEmail(this.getBookingEmail());
        bookingCommand.setCheckinStartDateTime(this.getCheckinStartDateTime());
        bookingCommand.setCheckinStartDateTime(this.getCheckinStartDateTime());
        bookingCommand.setBookingTotalFee(this.getBookingTotalFee());
        bookingCommand.setEnumOrderState(this.enumOrderState);
        bookingCommand.setLastModified(this.lastModified);
        bookingCommand.setCreatedBy(this.getCreatedBy());

        return bookingCommand;
    }
}
