package com.clonecoder.productserver.infrastructure;

import com.clonecoder.productserver.domain.AccommodationRoomFee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccommodationRoomFeeRepository extends JpaRepository<AccommodationRoomFee, Long> {

}
