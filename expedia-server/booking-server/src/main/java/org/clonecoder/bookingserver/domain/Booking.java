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
public class Booking {
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

    private String lastModifiedBy;
    private LocalDateTime lastModified;
    private String createdBy;
    private LocalDateTime createdAt;

    /**
     * bookingDto to Booking
     * @param bookingDto
     */
    public Booking(BookingDto bookingDto) {
        this.bookingNo = bookingDto.getBookingNo();
        this.accommodationRoomId = bookingDto.getAccommodationRoomId();
        this.bookingUserId = bookingDto.getBookingUserId();
        this.bookingLastName = bookingDto.getBookingLastName();
        this.bookingFirstName = bookingDto.getBookingFirstName();
        this.bookingHpno = bookingDto.getBookingHpno();
        this.bookingEmail = bookingDto.getBookingEmail();
        this.checkinStartDateTime = bookingDto.getCheckinStartDateTime();
        this.checkinEndDateTime = bookingDto.getCheckinEndDateTime();
        this.bookingTotalFee = bookingDto.getBookingTotalFee();
        this.orderState = bookingDto.getEnumOrderState();
        this.lastModifiedBy = bookingDto.getLastModifiedBy();
        this.createdBy = bookingDto.getCreatedBy();
    }
}
