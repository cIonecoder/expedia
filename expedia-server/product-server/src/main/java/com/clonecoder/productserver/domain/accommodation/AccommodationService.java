package com.clonecoder.productserver.domain.accommodation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccommodationService {
    private final AccommodationStore accommodationStore;

    public void stock() {
        log.info("stock()");
    }
}
