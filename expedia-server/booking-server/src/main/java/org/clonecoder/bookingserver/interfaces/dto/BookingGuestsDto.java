package org.clonecoder.bookingserver.interfaces.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.clonecoder.bookingserver.domain.Booking;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookingGuestsDto {
    private Long id;
    private Long booking_id;
    private Long guestUserId;
    private String guestType;
    private String guestLastName;
    private String guestFirstName;
    private String guestHpno;
    private String guestEmail;
    private int guestAge;
    private BigDecimal guestFee;
    private String lastModifiedBy;
    private LocalDateTime lastModified;
    private String createdBy;
    private LocalDateTime createdAt;
}
