package org.clonecoder.bookingserver.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.clonecoder.bookingserver.common.enums.EnumGuestType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class BookingGuests {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "booking_id")
    private Booking booking;

    @Enumerated(EnumType.STRING)
    private EnumGuestType guestType;

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
