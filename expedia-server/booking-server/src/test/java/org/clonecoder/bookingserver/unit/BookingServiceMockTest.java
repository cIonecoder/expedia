package org.clonecoder.bookingserver.unit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BookingServiceMockTest {
    @Test
    void 예약_생성() {
       // given : 예약 정보를 셋팅
       // when  : 예약 정보를 기반으로 생성 요청
       // then  : 원하는 예약이 생성됨
       //       : 예약한 게스트 수가 일치해야함
       //       : 게스트별 요금의 총 요금과 예약의 총 요금이 동일해야함
    }
}
