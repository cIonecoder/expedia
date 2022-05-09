package com.expedia.b2b.acceptance.accommodation;

import com.expedia.b2b.acceptance.AcceptanceTest;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

import static com.expedia.b2b.acceptance.accommodation.AccommodationParams.*;
import static com.expedia.b2b.acceptance.accommodation.AccommodationSteps.*;
import static org.assertj.core.api.Assertions.assertThat;

public class AccommodationAcceptanceTest extends AcceptanceTest {
    /*
       - given : 숙박업체 정보를 생성
       - when  : 숙박업체 정보를 기반으로 생성 요청
       - then  : 원하는 숙박업체의 정보로 숙박업체가 신규 생성됨
     */
    @Test
    @DisplayName("숙박업체를 생성한다.")
    void 숙박업체_생성() {
        // given
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

        // when
        ExtractableResponse<Response> response = 숙박업체_생성_요청(paramMap);

        // then
        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }

    /*
       - given : 숙박업체 정보를 생성
       - when  : 생성된 숙박업체 정보 조회 요청
       - then  : 정상적으로 생성된 숙박업체가 조회됨
     */
    @Test
    @DisplayName("숙박업체를 조회한다.")
    void 숙박업체_조회() {
        // given
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

        ExtractableResponse<Response> response = 숙박업체_생성_요청(paramMap);
        Long accommodationId = response.jsonPath().getLong("accommodationId");

        // when
        ExtractableResponse<Response> accommodationResponse = 숙박업체_조회_요청(accommodationId);

        // then
        assertThat(accommodationResponse.statusCode()).isEqualTo(HttpStatus.OK.value());
        assertThat(accommodationResponse.jsonPath().getLong("accommodationId")).isEqualTo(accommodationId);
    }
}
