package org.clonecoder.productserver.domain.accommodation;

import org.clonecoder.productserver.domain.AccommodationRoom;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccommodationService {
    private final AccommodationStore accommodationStore;

    public void stock(Long accommodationRoomId) {
        AccommodationRoom accommodationRoom = accommodationStore.getAccommodationRoom(accommodationRoomId);
        log.info("stock() : " + accommodationRoom.getStock());
    }
}
