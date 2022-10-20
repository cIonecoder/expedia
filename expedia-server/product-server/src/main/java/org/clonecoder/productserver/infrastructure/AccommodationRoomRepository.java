package org.clonecoder.productserver.infrastructure;

import org.clonecoder.productserver.domain.AccommodationRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccommodationRoomRepository extends JpaRepository<AccommodationRoom, Long> {

}
