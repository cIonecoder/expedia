package org.clonecoder.bookingserver.acceptance.booking;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import static org.clonecoder.bookingserver.param.ParamMap.예약_생성_정보_셋팅;

public class BookingSteps {
    @Test
    static ExtractableResponse<Response> 예약_생성_요청() {
        return RestAssured
                .given()
                    .log().all()
                    .contentType(MediaType.APPLICATION_JSON_VALUE)
                    .body(예약_생성_정보_셋팅())
                .when()
                    .post("/booking")
                .then()
                    .log().all()
                    .extract();
    }
}
