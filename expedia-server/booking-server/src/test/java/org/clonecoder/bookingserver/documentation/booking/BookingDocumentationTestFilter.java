package org.clonecoder.bookingserver.documentation.booking;

import org.springframework.http.HttpHeaders;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.restdocs.restassured3.RestDocumentationFilter;

import static org.clonecoder.bookingserver.documentation.DocumentationUtils.getDocumentRequest;
import static org.clonecoder.bookingserver.documentation.DocumentationUtils.getDocumentResponse;
import static org.springframework.restdocs.headers.HeaderDocumentation.headerWithName;
import static org.springframework.restdocs.headers.HeaderDocumentation.requestHeaders;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.restassured3.RestAssuredRestDocumentation.document;

public class BookingDocumentationTestFilter {
    public static RestDocumentationFilter 예약_생성_요청() {
        return document("post-booking",
                getDocumentRequest(),
                getDocumentResponse(),
                requestHeaders(
                        headerWithName(HttpHeaders.CONTENT_TYPE).description("Content-type")
                ),
                requestFields(
                        /* 예약_정보_셋팅 */
                        fieldWithPath("bookingDto.id").description("예약키 인덱스").ignored(),
                        fieldWithPath("bookingDto.bookingNo").description("예약번호"),
                        fieldWithPath("bookingDto.accommodationRoomId").description("숙박업체 상품 인덱스"),
                        fieldWithPath("bookingDto.bookingUserId").description("예약유저 인덱스"),
                        fieldWithPath("bookingDto.bookingLastName").description("예약자 성"),
                        fieldWithPath("bookingDto.bookingFirstName").description("예약자 이름"),
                        fieldWithPath("bookingDto.bookingHpno").description("예약자 휴대폰번호"),
                        fieldWithPath("bookingDto.bookingEmail").description("예약자 이메일"),
                        fieldWithPath("bookingDto.checkinStartDateTime").description("체크인 시작 시간"),
                        fieldWithPath("bookingDto.checkinEndDateTime").description("체크아웃 종료 시간"),
                        fieldWithPath("bookingDto.bookingTotalFee").description("예약 총 요금"),
                        fieldWithPath("bookingDto.enumOrderState").description("예약진행상태"),
                        fieldWithPath("bookingDto.createdBy").description("등록자"),
                        fieldWithPath("bookingDto.createdAt").description("등록일자").ignored(),
                        fieldWithPath("bookingDto.lastModifiedBy").description("수정자"),
                        fieldWithPath("bookingDto.lastModifiedAt").description("최근수정일자").ignored(),

                        /* 예약_게스트_정보_셋팅 */
                        fieldWithPath("bookingGuestsDtoList[].id").description("게스트키 인덱스"),
                        fieldWithPath("bookingGuestsDtoList[].bookingId").description("예약 인덱스"),
                        fieldWithPath("bookingGuestsDtoList[].enumGuestType").description("예약자 유형 코드(성인, 청소년, 유아 등)"),
                        fieldWithPath("bookingGuestsDtoList[].guestLastName").description("예약자 성"),
                        fieldWithPath("bookingGuestsDtoList[].guestFirstName").description("예약자 이름"),
                        fieldWithPath("bookingGuestsDtoList[].guestHpno").description("예약자 휴대폰번호"),
                        fieldWithPath("bookingGuestsDtoList[].guestEmail").description("예약자 이메일"),
                        fieldWithPath("bookingGuestsDtoList[].guestAge").description("예약자 나이"),
                        fieldWithPath("bookingGuestsDtoList[].guestFee").description("예약자 요금"),
                        fieldWithPath("bookingGuestsDtoList[].createdBy").description("등록자"),
                        fieldWithPath("bookingGuestsDtoList[].createdAt").description("등록일자").ignored(),
                        fieldWithPath("bookingGuestsDtoList[].lastModifiedBy").description("수정자"),
                        fieldWithPath("bookingGuestsDtoList[].lastModifiedAt").description("최근수정일자").ignored()
                ),
                responseFields(
                        fieldWithPath("status").description("결과코드"),
                        fieldWithPath("message").description("결과메시지"),
                        fieldWithPath("data").description("결과데이터")
                )
        );
    }
}
