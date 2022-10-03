package org.clonecoder.bookingserver.acceptance.booking;

import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.springframework.http.HttpStatus;
import org.clonecoder.bookingserver.acceptance.AcceptanceTest;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.clonecoder.bookingserver.acceptance.booking.BookingSteps.예약_생성_요청;

public class BookingAcceptanceTest extends AcceptanceTest {
    /*
       - given : 예약 정보를 셋팅
       - when  : 예약 정보를 기반으로 생성 요청
       - then  : 원하는 예약이 생성됨
     */
    @Test
    void 예약_생성() {
        // given
        // when
        ExtractableResponse<Response> response = 예약_생성_요청();

        // then
        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
    }
}
