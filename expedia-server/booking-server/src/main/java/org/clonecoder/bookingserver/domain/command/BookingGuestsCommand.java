package org.clonecoder.bookingserver.domain.command;

import lombok.Getter;
import lombok.Setter;
import org.clonecoder.bookingserver.domain.enums.EnumGuestType;
import org.clonecoder.bookingserver.domain.BookingGuests;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class BookingGuestsCommand {
    private Long id;
    private Long bookingId;
    private EnumGuestType enumGuestType;
    private String guestLastName;
    private String guestFirstName;
    private String guestHpno;
    private String guestEmail;
    private int guestAge;
    private BigDecimal guestFee;
    private String lastModifiedBy;
    private String createdBy;

    public BookingGuests toEntity() {
        return new BookingGuests(this);
    }
}
