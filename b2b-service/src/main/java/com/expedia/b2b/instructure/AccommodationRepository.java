package com.expedia.b2b.instructure;

import com.expedia.b2b.domain.Accommodation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccommodationRepository extends JpaRepository<Accommodation, Long> {

}
