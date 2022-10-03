package org.clonecoder.bookingserver.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.clonecoder.bookingserver.domain.enums.EnumOrderState;
import org.clonecoder.bookingserver.domain.command.BookingCommand;

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

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "last", column = @Column(name = "booking_last_name")),
            @AttributeOverride(name = "first", column = @Column(name = "booking_first_name"))
    })
    private Name name;

    @Embedded
    @AttributeOverride(name = "phone", column = @Column(name = "booking_hpno"))
    private Phone bookingHpno;

    @Embedded
    @AttributeOverride(name = "email", column = @Column(name = "booking_email"))
    private Email bookingEmail;

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
        this.name = new Name(bookingCommand.getBookingLastName(), bookingCommand.getBookingFirstName());
        this.bookingHpno = new Phone(bookingCommand.getBookingHpno());
        this.bookingEmail = new Email(bookingCommand.getBookingEmail());
        this.checkinStartDateTime = bookingCommand.getCheckinStartDateTime();
        this.checkinEndDateTime = bookingCommand.getCheckinEndDateTime();
        this.bookingTotalFee = bookingCommand.getBookingTotalFee();
        this.orderState = bookingCommand.getEnumOrderState();
        this.setLastModifiedBy(bookingCommand.getLastModifiedBy());
        this.setCreatedBy(bookingCommand.getCreatedBy());
    }
}
