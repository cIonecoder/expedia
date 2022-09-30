package org.clonecoder.bookingserver.acceptance.booking;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.clonecoder.bookingserver.acceptance.booking.BookingParams.*;

public class BookingSteps {
    @Test
    static ExtractableResponse<Response> 예약_생성_요청() {
        Map<String, Object> bookingMap = 예약_정보_셋팅();
        List<Map<String, Object>> bookingGuestsList = 예약_게스트_정보_셋팅();

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("bookingDto", bookingMap);
        paramMap.put("bookingGuestsDtoList", bookingGuestsList);

        return RestAssured
                .given()
                    .log().all()
                    .contentType(MediaType.APPLICATION_JSON_VALUE)
                    .body(paramMap)
                .when()
                    .post("/booking")
                .then()
                    .log().all()
                .extract();
    }
}
