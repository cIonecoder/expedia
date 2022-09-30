package org.clonecoder.bookingserver.acceptance.booking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class BookingParams {
    public static Map<String, Object> 예약_정보_셋팅() {
        Map<String, Object> params = new HashMap<>();
        params.put("bookingNo", "A25BD-20220928");
        params.put("accommodationRoomId", 9);
        params.put("bookingUserId", "test1234");
        params.put("bookingLastName", "KIM");
        params.put("bookingFirstName", "SEOHAE");
        params.put("bookingHpno", "01012341234");
        params.put("bookingEmail", "test@naver.com");
        params.put("checkinStartDateTime", "2022-09-29 08:00:00");
        params.put("checkinEndDateTime", "2022-09-29 12:00:00");
        params.put("bookingTotalFee", "50000");
        params.put("bookingStat", "ORDERE_CREATED"); // ORDERE_CREATED, ORDER_COMPLETED, PAYMENT_REQUEST
        params.put("lastModifiedBy", "test@naver.com");
        params.put("createdBy", "test@naver.com");

        return params;
    }

    public static List<Map<String, Object>> 예약_게스트_정보_셋팅() {
        List<Map<String, Object>> guests = new ArrayList<>();

        Map<String, Object> adult1 = new HashMap<>();
        adult1.put("bookingId", 1);
        adult1.put("guestUserId", 2);
        adult1.put("guestType", "ADULT");
        adult1.put("guestLastName", "KIM");
        adult1.put("guestFirstName", "SEOHAEM");
        adult1.put("guestHpno", "01012341111");
        adult1.put("guestEmail", "adult1@gmail.com");
        adult1.put("guestAge", 22);
        adult1.put("guestFee", 20000);
        adult1.put("lastModifiedBy", "test@naver.com");
        adult1.put("createdBy", "test@naver.com");

        guests.add(adult1);

        Map<String, Object> adult2 = new HashMap<>();
        adult2.put("bookingId", 1);
        adult2.put("guestUserId", 2);
        adult2.put("guestType", "ADULT");
        adult2.put("guestLastName", "KIM");
        adult2.put("guestFirstName", "SEOHAEM");
        adult2.put("guestHpno", "01012342222");
        adult2.put("guestEmail", "adult2@gmail.com");
        adult2.put("guestAge", 22);
        adult2.put("guestFee", 20000);
        adult2.put("lastModifiedBy", "adult2@naver.com");
        adult2.put("createdBy", "adult2@naver.com");

        guests.add(adult2);

        Map<String, Object> idol1 = new HashMap<>();
        idol1.put("bookingId", 1);
        idol1.put("guestUserId", 3);
        idol1.put("guestType", "IDOL");
        idol1.put("guestLastName", "KIM");
        idol1.put("guestFirstName", "IDOL");
        idol1.put("guestHpno", "01012343333");
        idol1.put("guestEmail", "idol1@gmail.com");
        idol1.put("guestAge", 14);
        idol1.put("guestFee", 10000);
        idol1.put("lastModifiedBy", "idol1@naver.com");
        idol1.put("createdBy", "idol1@naver.com");

        guests.add(idol1);

        return guests;
    }
}