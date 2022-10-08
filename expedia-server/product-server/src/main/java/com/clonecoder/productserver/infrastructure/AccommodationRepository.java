package com.clonecoder.productserver.infrastructure;

import com.clonecoder.productserver.domain.Accommodation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccommodationRepository extends JpaRepository<Accommodation, Long> {

}
