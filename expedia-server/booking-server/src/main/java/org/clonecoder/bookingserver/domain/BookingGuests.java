package org.clonecoder.bookingserver.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.clonecoder.bookingserver.common.enums.EnumGuestType;
import org.clonecoder.bookingserver.domain.command.BookingGuestsCommand;
import org.clonecoder.bookingserver.interfaces.dto.BookingGuestsDto;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor
public class BookingGuests extends BaseEntity {
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

    /**
     * BookingGuestsDto to BookingGuests
     * @param bookingGuestsCommand
     */
    public BookingGuests(BookingGuestsCommand bookingGuestsCommand) {
        this.guestType = bookingGuestsCommand.getEnumGuestType();
        this.guestLastName = bookingGuestsCommand.getGuestLastName();
        this.guestFirstName = bookingGuestsCommand.getGuestFirstName();
        this.guestHpno = bookingGuestsCommand.getGuestHpno();
        this.guestEmail = bookingGuestsCommand.getGuestEmail();
        this.guestAge = bookingGuestsCommand.getGuestAge();
        this.guestFee = bookingGuestsCommand.getGuestFee();
        this.setLastModifiedBy(bookingGuestsCommand.getLastModifiedBy());
        this.setCreatedBy(bookingGuestsCommand.getCreatedBy());
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
