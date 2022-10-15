package org.clonecoder.productserver.infrastructure;

import org.clonecoder.productserver.domain.AccommodationRoomInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccommodationRoomInfoRepository extends JpaRepository<AccommodationRoomInfo, Long> {

}
