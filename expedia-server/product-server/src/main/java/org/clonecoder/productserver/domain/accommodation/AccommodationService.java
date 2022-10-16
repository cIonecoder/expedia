package org.clonecoder.productserver.domain.accommodation;

import org.clonecoder.productserver.common.aop.RedissonLock;
import org.clonecoder.productserver.domain.AccommodationRoom;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccommodationService {
    private final AccommodationStore accommodationStore;

    @RedissonLock(key = "accommodationRoomId")
    public void stockDecrease(Long accommodationRoomId) {
        log.info("Thread Name : " + Thread.currentThread().getName());

        AccommodationRoom accommodationRoom = accommodationStore.getAccommodationRoom(accommodationRoomId);
        log.info("stock() : " + accommodationRoom.getStock());

        accommodationRoom.stockDecrease();
        log.info("decrease after stock() : " + accommodationRoom.getStock());
    }
}
