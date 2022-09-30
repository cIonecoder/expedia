package org.clonecoder.bookingserver.documentation.accommodation;

import org.springframework.http.HttpHeaders;
import org.springframework.restdocs.restassured3.RestDocumentationFilter;

import static org.clonecoder.bookingserver.documentation.DocumentationUtils.getDocumentRequest;
import static org.clonecoder.bookingserver.documentation.DocumentationUtils.getDocumentResponse;
import static org.springframework.restdocs.headers.HeaderDocumentation.headerWithName;
import static org.springframework.restdocs.headers.HeaderDocumentation.requestHeaders;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.restassured3.RestAssuredRestDocumentation.document;

public class BookingDocumentationTest {
    public static RestDocumentationFilter 예약_생성_요청() {
        return document("post-booking",
                getDocumentRequest(),
                getDocumentResponse(),
                requestHeaders(
                        headerWithName(HttpHeaders.CONTENT_TYPE).description("Content-type")
                ),
                requestFields(
                        /* 예약_정보_셋팅 */
                        fieldWithPath("bookingNo").description("예약번호"),
                        fieldWithPath("accommodationRoomId").description("숙박업체 상품 인덱스"),
                        fieldWithPath("bookingUserId").description("예약유저 인덱스"),
                        fieldWithPath("bookingLastName").description("예약자 성"),
                        fieldWithPath("bookingFirstName").description("예약자 이름"),
                        fieldWithPath("bookingHpno").description("예약자 휴대폰번호"),
                        fieldWithPath("bookingEmail").description("예약자 이메일"),
                        fieldWithPath("checkinStartDateTime").description("체크인 시작 시간"),
                        fieldWithPath("checkinEndDateTime").description("체크아웃 종료 시간"),
                        fieldWithPath("bookingTotalFee").description("예약 총 요금"),
                        fieldWithPath("bookingStat").description("예약진행상태"),
                        fieldWithPath("lastModifiedBy").description("수정자"),
                        fieldWithPath("createdBy").description("등록자"),

                        /* 예약_게스트_정보_셋팅 */
                        fieldWithPath("bookingId").description("예약 인덱스"),
                        fieldWithPath("guestType").description("예약자 유형 코드(성인, 청소년, 유아 등)"),
                        fieldWithPath("guestLastName").description("예약자 성"),
                        fieldWithPath("guestFirstName").description("예약자 이름"),
                        fieldWithPath("guestHpno").description("예약자 휴대폰번호"),
                        fieldWithPath("guestEmail").description("예약자 이메일"),
                        fieldWithPath("guestAge").description("예약자 나이"),
                        fieldWithPath("guestFee").description("예약자 요금"),
                        fieldWithPath("lastModifiedBy").description("수정자"),
                        fieldWithPath("createdBy").description("등록자")
                ),
                responseFields(
                        fieldWithPath("bookingId").description("예약 인덱스"),
                        fieldWithPath("bookingNo").description("예약번호")
                )
        );
    }
}
