package org.clonecoder.bookingserver.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.clonecoder.bookingserver.common.enums.EnumOrderState;
import org.clonecoder.bookingserver.domain.command.BookingCommand;
import org.clonecoder.bookingserver.interfaces.dto.BookingDto;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor
public class Booking extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Enumerated(EnumType.STRING)
    private EnumOrderState orderState;

    /**
     * bookingDto to Booking
     * @param bookingCommand
     */
    public Booking(BookingCommand bookingCommand) {
        this.bookingNo = bookingCommand.getBookingNo();
        this.accommodationRoomId = bookingCommand.getAccommodationRoomId();
        this.bookingUserId = bookingCommand.getBookingUserId();
        this.bookingLastName = bookingCommand.getBookingLastName();
        this.bookingFirstName = bookingCommand.getBookingFirstName();
        this.bookingHpno = bookingCommand.getBookingHpno();
        this.bookingEmail = bookingCommand.getBookingEmail();
        this.checkinStartDateTime = bookingCommand.getCheckinStartDateTime();
        this.checkinEndDateTime = bookingCommand.getCheckinEndDateTime();
        this.bookingTotalFee = bookingCommand.getBookingTotalFee();
        this.orderState = bookingCommand.getEnumOrderState();
        this.setLastModifiedBy(bookingCommand.getLastModifiedBy());
        this.setCreatedBy(bookingCommand.getCreatedBy());
    }
}
