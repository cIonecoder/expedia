package org.clonecoder.bookingserver.interfaces.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.clonecoder.bookingserver.common.enums.EnumOrderState;

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
}
