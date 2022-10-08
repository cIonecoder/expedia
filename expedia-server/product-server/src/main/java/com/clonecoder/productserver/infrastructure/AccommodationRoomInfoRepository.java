package com.clonecoder.productserver.infrastructure;

import com.clonecoder.productserver.domain.AccommodationRoomInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccommodationRoomInfoRepository extends JpaRepository<AccommodationRoomInfo, Long> {

}
