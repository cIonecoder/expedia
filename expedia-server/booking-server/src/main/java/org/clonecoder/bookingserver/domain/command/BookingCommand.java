package org.clonecoder.bookingserver.domain.command;

import lombok.Getter;
import lombok.Setter;
import org.clonecoder.bookingserver.domain.enums.EnumOrderState;
import org.clonecoder.bookingserver.domain.Booking;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class BookingCommand {
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

    public Booking toEntity() {
        return new Booking(this);
    }
}
