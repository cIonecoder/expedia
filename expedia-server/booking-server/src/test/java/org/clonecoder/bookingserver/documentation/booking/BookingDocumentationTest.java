package org.clonecoder.bookingserver.documentation.booking;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.clonecoder.bookingserver.documentation.Documentation;
import org.clonecoder.bookingserver.interfaces.dto.RequestBookingDto;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static org.assertj.core.api.Assertions.assertThat;
import static org.clonecoder.bookingserver.param.ParamDto.예약_생성_정보_셋팅;

public class BookingDocumentationTest extends Documentation {
    @Test
    void 예약_생성_요청() {
        RequestBookingDto.saveDto requestBookingSaveDto = new RequestBookingDto.saveDto();
        예약_생성_정보_셋팅(requestBookingSaveDto);

        ExtractableResponse<Response> response = RestAssured
                .given(this.spec)
                    .log().all()
                    .contentType(MediaType.APPLICATION_JSON_VALUE)
                    .filter(BookingDocumentationTestFilter.예약_생성_요청())
                    .body(requestBookingSaveDto)
                .when()
                    .post("/booking")
                .then()
                    .log().all()
                    .extract();

        // then
        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
    }
}
