package org.clonecoder.productserver.infrastructure;

import org.clonecoder.productserver.domain.Accommodation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccommodationRepository extends JpaRepository<Accommodation, Long> {

}
