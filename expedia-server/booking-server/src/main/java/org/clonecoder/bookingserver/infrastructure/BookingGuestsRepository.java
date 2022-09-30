package org.clonecoder.bookingserver.infrastructure;

import org.clonecoder.bookingserver.domain.BookingGuests;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingGuestsRepository extends JpaRepository<BookingGuests, Long> {

}
