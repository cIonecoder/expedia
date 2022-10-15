package org.clonecoder.bookingserver.param;

import org.clonecoder.bookingserver.domain.enums.EnumGuestType;
import org.clonecoder.bookingserver.domain.enums.EnumOrderState;
import org.clonecoder.bookingserver.interfaces.dto.BookingDto;
import org.clonecoder.bookingserver.interfaces.dto.BookingGuestsDto;
import org.clonecoder.bookingserver.interfaces.dto.RequestBookingDto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public final class ParamDto {
    public static void 예약_생성_정보_셋팅(RequestBookingDto.saveDto requestBookingSaveDto) {
        예약_정보_셋팅(requestBookingSaveDto);
        예약_게스트_정보_셋팅(requestBookingSaveDto);
    }

    private static void 예약_정보_셋팅(RequestBookingDto.saveDto requestBookingSaveDto) {
        BookingDto bookingDto = new BookingDto();
        bookingDto.setBookingNo("A25BD-20220928");
        bookingDto.setAccommodationRoomId(1L);
        bookingDto.setBookingUserId("test1234");
        bookingDto.setBookingLastName("KIM");
        bookingDto.setBookingFirstName("SEOHAE");
        bookingDto.setBookingHpno("01012341234");
        bookingDto.setBookingEmail("test@naver.com");
        bookingDto.setCheckinStartDateTime(LocalDateTime.of(2022, 9, 26, 16, 0, 0));
        bookingDto.setCheckinEndDateTime(LocalDateTime.of(2022, 9, 30, 11, 0, 0));
        bookingDto.setBookingTotalFee(new BigDecimal(30000));
        bookingDto.setEnumOrderState(EnumOrderState.ORDER_CREATED);
        bookingDto.setLastModifiedBy("test@naver.com");
        bookingDto.setCreatedBy("test@naver.com");

        requestBookingSaveDto.setBookingDto(bookingDto);
    }

    private static void 예약_게스트_정보_셋팅(RequestBookingDto.saveDto requestBookingSaveDto) {
        List<BookingGuestsDto> bookingGuestsDtoList = new ArrayList<>();

        BookingGuestsDto guest1 = new BookingGuestsDto();
        guest1.setEnumGuestType(EnumGuestType.ADULT);
        guest1.setGuestLastName("KIM");
        guest1.setGuestFirstName("SEOHAEM");
        guest1.setGuestHpno("01012342222");
        guest1.setGuestEmail("adult1@gmail.com");
        guest1.setGuestAge(22);
        guest1.setGuestFee(new BigDecimal(20000));
        guest1.setLastModifiedBy("test@naver.com");
        guest1.setCreatedBy("test@naver.com");

        bookingGuestsDtoList.add(guest1);

        BookingGuestsDto guest2 = new BookingGuestsDto();
        guest2.setEnumGuestType(EnumGuestType.ADULT);
        guest2.setGuestLastName("LEE");
        guest2.setGuestFirstName("SEOHAEM");
        guest2.setGuestHpno("01012342222");
        guest2.setGuestEmail("idol1@gmail.com");
        guest2.setGuestAge(16);
        guest2.setGuestFee(new BigDecimal(10000));
        guest2.setLastModifiedBy("test@naver.com");
        guest2.setCreatedBy("test@naver.com");

        bookingGuestsDtoList.add(guest2);

        requestBookingSaveDto.setBookingGuestsDtoList(bookingGuestsDtoList);
    }
}
