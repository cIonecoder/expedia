package org.clonecoder.bookingserver.unit.domain.booking;

import org.clonecoder.bookingserver.domain.command.BookingGuestsCommand;
import org.clonecoder.bookingserver.domain.enums.EnumGuestType;
import org.clonecoder.bookingserver.domain.enums.EnumOrderState;
import org.clonecoder.bookingserver.domain.Booking;
import org.clonecoder.bookingserver.domain.BookingGuests;
import org.clonecoder.bookingserver.domain.booking.BookingService;
import org.clonecoder.bookingserver.infrastructure.BookingGuestsRepository;
import org.clonecoder.bookingserver.infrastructure.BookingRepository;
import org.clonecoder.bookingserver.interfaces.dto.BookingDto;
import org.clonecoder.bookingserver.interfaces.dto.BookingGuestsDto;
import org.clonecoder.bookingserver.interfaces.dto.RequestBookingDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class BookingServiceTest {
    @Autowired
    private BookingService bookingService;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private BookingGuestsRepository bookingGuestsRepository;

    private final RequestBookingDto.saveDto requestBookingSaveDto = new RequestBookingDto.saveDto();

    @BeforeEach
    void setUp() {
        createParam();
    }

    @Test
    void 예약_생성() {
        // given : 예약 정보를 셋팅
        BookingDto bookingDto = requestBookingSaveDto.getBookingDto();

        // given : 예약 게스트 정보를 셋팅
        List<BookingGuestsDto> bookingGuestsDtoList = requestBookingSaveDto.getBookingGuestsDto();
        List<BookingGuestsCommand> bookingGuestsCommandList = bookingGuestsDtoList.stream()
                .map(BookingGuestsDto::toCommand)
                .collect(Collectors.toList());

        // when  : 예약 정보를 기반으로 생성 요청
        Booking resultBooking = bookingService.saveBooking(bookingDto.toCommand(), bookingGuestsCommandList);


        // then
        Optional<Booking> findBooking = bookingRepository.findById(resultBooking.getId());
        List<BookingGuests> findBookingGuests = bookingGuestsRepository.findAll();

        // 1) 원하는 예약이 생성됨
        assertThat(findBooking.get().getId()).isEqualTo(findBookingGuests.get(0).getBooking().getId());

        // 2) 예약한 게스트 수가 일치해야함
        assertThat(findBookingGuests.size()).isEqualTo(requestBookingSaveDto.getBookingGuestsDto().size());

        // 3) 게스트별 요금의 총 요금과 예약의 총 요금이 동일해야함
        BigDecimal totalFee = findBookingGuests.stream()
                .map(BookingGuests::getGuestFee)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        assertThat(findBooking.get().getBookingTotalFee()).isEqualTo(totalFee);
    }

    private void createParam() {
        List<BookingGuestsDto> bookingGuestsDtoList = new ArrayList<>();

        BookingDto bookingDto = new BookingDto();
        bookingDto.setBookingNo("A25BD-20220928");
        bookingDto.setAccommodationRoomId(9L);
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

        requestBookingSaveDto.setBookingDto(bookingDto);
        requestBookingSaveDto.setBookingGuestsDto(bookingGuestsDtoList);
    }
}