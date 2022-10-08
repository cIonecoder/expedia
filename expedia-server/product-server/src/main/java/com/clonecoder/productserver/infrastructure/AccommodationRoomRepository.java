package com.clonecoder.productserver.infrastructure;

import com.clonecoder.productserver.domain.AccommodationRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccommodationRoomRepository extends JpaRepository<AccommodationRoom, Long> {

}
