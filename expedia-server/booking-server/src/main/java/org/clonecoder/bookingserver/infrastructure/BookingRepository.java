package org.clonecoder.bookingserver.infrastructure;

import org.clonecoder.bookingserver.domain.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {

}
