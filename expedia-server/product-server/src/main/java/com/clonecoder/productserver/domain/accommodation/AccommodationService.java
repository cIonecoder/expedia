package com.clonecoder.productserver.domain.accommodation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccommodationService {
    private final AccommodationStore accommodationStore;
}
