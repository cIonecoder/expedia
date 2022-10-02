package org.clonecoder.bookingserver.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.clonecoder.bookingserver.common.enums.EnumGuestType;
import org.clonecoder.bookingserver.interfaces.dto.BookingGuestsDto;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor
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

    /**
     * BookingGuestsDto to BookingGuests
     * @param bookingGuestsDto
     */
    public BookingGuests(BookingGuestsDto bookingGuestsDto) {
        this.guestType = bookingGuestsDto.getEnumGuestType();
        this.guestLastName = bookingGuestsDto.getGuestLastName();
        this.guestFirstName = bookingGuestsDto.getGuestFirstName();
        this.guestHpno = bookingGuestsDto.getGuestHpno();
        this.guestEmail = bookingGuestsDto.getGuestEmail();
        this.guestAge = bookingGuestsDto.getGuestAge();
        this.guestFee = bookingGuestsDto.getGuestFee();
        this.lastModifiedBy = bookingGuestsDto.getLastModifiedBy();
        this.lastModified = bookingGuestsDto.getLastModified();
        this.createdBy = bookingGuestsDto.getCreatedBy();
    }

    /**
     * privte booking set
     * @param booking
     */
    private void setBooking(Booking booking) {
        this.booking = booking;
    }

    /**
     * booking setting
     * @param booking
     */
    public void settingBooking(Booking booking) {
        this.setBooking(booking);
    }
}
