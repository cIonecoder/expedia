package org.clonecoder.bookingserver.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.clonecoder.bookingserver.common.enums.EnumOrderState;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
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
}
