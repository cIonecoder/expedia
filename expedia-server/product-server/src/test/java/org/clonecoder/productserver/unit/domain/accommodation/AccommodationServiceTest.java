package org.clonecoder.productserver.unit.domain.accommodation;

import org.clonecoder.productserver.domain.AccommodationRoom;
import org.clonecoder.productserver.domain.accommodation.AccommodationService;
import org.clonecoder.productserver.infrastructure.AccommodationRoomRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@Sql({"classpath:accommodation/schema/accommodation.sql", "classpath:accommodation/data/accommodation_1.sql"})
class AccommodationServiceTest {
    @Autowired
    private AccommodationService accommodationService;

    @Autowired
    private AccommodationRoomRepository accommodationRoomRepository;

    @Test
    void 멀티쓰레드_재고감소() throws InterruptedException {
        // given
        final Long accommodationRoomIdx = 1L;
        AccommodationRoom accommodationRoom = accommodationRoomRepository.findById(accommodationRoomIdx).get();
        int threadCount = accommodationRoom.getStock();

        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
        CountDownLatch countDownLatch = new CountDownLatch(threadCount);

        // when
        IntStream.range(0, threadCount).forEach(e -> executorService.submit(() -> {
                try {
                    accommodationService.stockDecrease(accommodationRoomIdx);
                } finally {
                    countDownLatch.countDown();
                }
            }
        ));

        countDownLatch.await();

        // then
        accommodationRoom = accommodationRoomRepository.findById(accommodationRoomIdx).get();
        int afterStock = accommodationRoom.getStock();

        assertThat(afterStock).isZero();
    }
}