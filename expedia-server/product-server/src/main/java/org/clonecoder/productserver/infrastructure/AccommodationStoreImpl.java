package org.clonecoder.productserver.infrastructure;

import lombok.extern.slf4j.Slf4j;
import org.clonecoder.productserver.common.aop.RedissonLock;
import org.clonecoder.productserver.common.enums.ExceptionMessage;
import org.clonecoder.productserver.common.exception.BadRequestException;
import org.clonecoder.productserver.domain.AccommodationRoom;
import org.clonecoder.productserver.domain.accommodation.AccommodationStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccommodationStoreImpl implements AccommodationStore {
    private final AccommodationRoomRepository accommodationRoomRepository;

    @RedissonLock(key = "accommodationRoomId")
    public void stockDecrease(Long accommodationRoomId) {
        log.info("Thread Name : " + Thread.currentThread().getName());

        Optional<AccommodationRoom> byId = accommodationRoomRepository.findById(accommodationRoomId);

        if (byId.isEmpty()) {
            throw new BadRequestException(ExceptionMessage.NOT_EXIST_ACCOMMODATION_ROOM);
        }

        AccommodationRoom accommodationRoom = byId.get();
        log.info("stock() : " + accommodationRoom.getStock());

        accommodationRoom.stockDecrease();

        log.info("decrease after stock() : " + accommodationRoom.getStock());
    }
}
