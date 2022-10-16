package org.clonecoder.bookingserver.application.booking;

import lombok.RequiredArgsConstructor;
import org.clonecoder.bookingserver.domain.booking.BookingService;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
public class RedissonLockFacade {
    private final RedissonClient redissonClient;
    private final BookingService bookingService;

    public void accommodationRoomStockDecrease(final Long accommodationRoomId) {
        // key 로 Lock 객체 가져온다.
        final RLock lock = redissonClient.getLock(accommodationRoomId.toString());

        try {
            // 획득 시도 시간, 락 점유 시간
            if (!lock.tryLock(30, 1, TimeUnit.SECONDS)) {
                System.out.println("redisson getLock timeout");
                return;
            }

            // service call
            bookingService.accommodationRoomStockDecrease(accommodationRoomId);

        } catch (InterruptedException e) {
            // TODO Exception 처리
            throw new RuntimeException(e);
        } finally {
            // unlock the lock object
            lock.unlock();
        }
    }
}
