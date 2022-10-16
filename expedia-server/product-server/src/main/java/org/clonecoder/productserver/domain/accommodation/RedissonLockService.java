package org.clonecoder.productserver.domain.accommodation;

import lombok.RequiredArgsConstructor;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
public class RedissonLockService {
    private final RedissonClient redissonClient;

    public void stockDecrease(final Long accommodationRoomId) throws InterruptedException {
        // key 로 Lock 객체 가져온다.
        final RLock lock = redissonClient.getLock(accommodationRoomId.toString());

        try {
            // 획득 시도 시간, 락 점유 시간
            if (!lock.tryLock(30, 1, TimeUnit.SECONDS)) {
                System.out.println("redisson getLock timeout");
                return;
            }

            // service call

        } finally {
            // unlock the lock object
            lock.unlock();
        }
    }
}
