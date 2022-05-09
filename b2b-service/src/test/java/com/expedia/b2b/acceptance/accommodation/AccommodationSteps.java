package com.expedia.b2b.acceptance.accommodation;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import java.util.Map;

public class AccommodationSteps {
    @Test
    @DisplayName("숙박업체를 생성한다.")
    static ExtractableResponse<Response> 숙박업체_생성_요청(Map<String, Object> paramMap) {
        return RestAssured
                .given()
                    .log().all()
                    .contentType(MediaType.APPLICATION_JSON_VALUE)
                    .body(paramMap)
                .when()
                    .post("/accommodations")
                .then()
                    .log().all()
                .extract();
    }

    @Test
    @DisplayName("숙박업체를 조회한다.")
    static ExtractableResponse<Response> 숙박업체_조회_요청(Long accommodationId) {
        return RestAssured
                .given()
                    .log().all()
                .when()
                    .get("/accommodation/{accommodationId}", accommodationId)
                .then()
                    .log().all()
                .extract();
    }
}
