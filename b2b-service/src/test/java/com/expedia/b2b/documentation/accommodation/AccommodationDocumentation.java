package com.expedia.b2b.documentation.accommodation;

import com.expedia.b2b.documentation.Documentation;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import java.util.HashMap;
import java.util.Map;

import static com.expedia.b2b.acceptance.accommodation.AccommodationParams.객실_부가정보_셋팅;
import static com.expedia.b2b.acceptance.accommodation.AccommodationParams.객실_요금_셋팅;
import static com.expedia.b2b.acceptance.accommodation.AccommodationParams.객실_정보_셋팅;
import static com.expedia.b2b.acceptance.accommodation.AccommodationParams.숙박업체_권한_정보_셋팅;
import static com.expedia.b2b.acceptance.accommodation.AccommodationParams.숙박업체_정보_셋팅;

public class AccommodationDocumentation extends Documentation {
    @Test
    void 숙박업체_생성_요청() {
        Map<String, Object> accommodationMap = 숙박업체_정보_셋팅();
        Map<String, Object> accommodationRoleMap = 숙박업체_권한_정보_셋팅();
        Map<String, Object> accommodationRoomMap = 객실_정보_셋팅();
        Map<String, Object> accommodationRoomInfoMap = 객실_부가정보_셋팅();
        Map<String, Object> accommodationRoomFeeMap = 객실_요금_셋팅();

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("accommodationDto", accommodationMap);
        paramMap.put("accommodationRoleDto", accommodationRoleMap);
        paramMap.put("accommodationRoomDto", accommodationRoomMap);
        paramMap.put("accommodationRoomInfoDto", accommodationRoomInfoMap);
        paramMap.put("accommodationRoomFeeDto", accommodationRoomFeeMap);

        RestAssured
                .given()
                    .log().all()
                .accept(MediaType.APPLICATION_JSON_VALUE)
                    .body(paramMap)
                .when()
                    .post("/accommodations")
                .then()
                    .log().all()
                .extract();
    }

    @Test
    void 숙박업체_조회_요청() {
        RestAssured
                .given()
                    .log().all()
                .accept(MediaType.APPLICATION_JSON_VALUE)
                    .queryParam("accommodationId", 1L)
                .when()
                    .get("/accommodations")
                .then()
                    .log().all()
                .extract();
    }
}
