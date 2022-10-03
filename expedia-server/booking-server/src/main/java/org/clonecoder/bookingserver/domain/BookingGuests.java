package org.clonecoder.bookingserver.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.clonecoder.bookingserver.domain.enums.EnumGuestType;
import org.clonecoder.bookingserver.domain.command.BookingGuestsCommand;

import javax.persistence.*;
import java.math.BigDecimal;

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

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "last", column = @Column(name = "guest_last_name")),
            @AttributeOverride(name = "first", column = @Column(name = "guest_first_name"))
    })
    private Name name;

    @Embedded
    @AttributeOverride(name = "phone", column = @Column(name = "guest_hpno"))
    private Phone guestHpno;

    @Embedded
    @AttributeOverride(name = "email", column = @Column(name = "guest_email"))
    private Email guestEmail;

    private int guestAge;
    private BigDecimal guestFee;

    /**
     * BookingGuestsDto to BookingGuests
     * @param bookingGuestsCommand
     */
    public BookingGuests(BookingGuestsCommand bookingGuestsCommand) {
        this.guestType = bookingGuestsCommand.getEnumGuestType();
        this.name = new Name(bookingGuestsCommand.getGuestLastName(), bookingGuestsCommand.getGuestFirstName());
        this.guestHpno = new Phone(bookingGuestsCommand.getGuestHpno());
        this.guestEmail = new Email(bookingGuestsCommand.getGuestEmail());
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
