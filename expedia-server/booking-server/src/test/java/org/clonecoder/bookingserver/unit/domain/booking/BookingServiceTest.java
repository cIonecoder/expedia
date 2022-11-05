package org.clonecoder.bookingserver.unit.domain.booking;

import org.clonecoder.bookingserver.BookingTest;
import org.clonecoder.bookingserver.domain.Booking;
import org.clonecoder.bookingserver.domain.BookingGuests;
import org.clonecoder.bookingserver.domain.booking.BookingService;
import org.clonecoder.bookingserver.domain.command.BookingGuestsCommand;
import org.clonecoder.bookingserver.infrastructure.BookingGuestsRepository;
import org.clonecoder.bookingserver.infrastructure.BookingRepository;
import org.clonecoder.bookingserver.interfaces.dto.BookingDto;
import org.clonecoder.bookingserver.interfaces.dto.BookingGuestsDto;
import org.clonecoder.bookingserver.interfaces.dto.RequestBookingDto;
import org.clonecoder.productserver.domain.AccommodationRoom;
import org.clonecoder.productserver.infrastructure.AccommodationRoomRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.clonecoder.bookingserver.param.ParamDto.예약_생성_정보_셋팅;

class BookingServiceTest extends BookingTest {
    @Autowired
    private BookingService bookingService;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private BookingGuestsRepository bookingGuestsRepository;

    @Autowired
    private AccommodationRoomRepository accommodationRoomRepository;

    private final RequestBookingDto.saveDto requestBookingSaveDto = new RequestBookingDto.saveDto();

    @BeforeEach
    void setUp() {
        예약_생성_정보_셋팅(requestBookingSaveDto);
    }

    @Test
    void 예약_생성() {
        // given : 예약 정보를 셋팅
        BookingDto bookingDto = requestBookingSaveDto.getBookingDto();

        // given : 예약 게스트 정보를 셋팅
        List<BookingGuestsDto> bookingGuestsDtoList = requestBookingSaveDto.getBookingGuestsDtoList();
        List<BookingGuestsCommand> bookingGuestsCommandList = bookingGuestsDtoList.stream()
                .map(BookingGuestsDto::toCommand)
                .collect(Collectors.toList());

        AccommodationRoom accommodationRoom = accommodationRoomRepository.findById(bookingDto.getAccommodationRoomId()).get();
        int beforeStock = accommodationRoom.getStock();

        // when  : 예약 정보를 기반으로 생성 요청
        Booking resultBooking = bookingService.saveBooking(bookingDto.toCommand(), bookingGuestsCommandList);

        accommodationRoom = accommodationRoomRepository.findById(bookingDto.getAccommodationRoomId()).get();
        int afterStock = accommodationRoom.getStock();

        // then
        Optional<Booking> findBooking = bookingRepository.findById(resultBooking.getId());
        List<BookingGuests> findBookingGuests =
                bookingGuestsRepository.findAll().stream()
                        .filter(bookingGuests -> bookingGuests.getBooking().getId().equals(resultBooking.getId()))
                        .collect(Collectors.toList());

        // 1) 원하는 예약이 생성됨
        assertThat(resultBooking.getId()).isEqualTo(findBookingGuests.get(0).getBooking().getId());

        // 2) 예약한 게스트 수가 일치해야함
        assertThat(findBookingGuests.size()).isEqualTo(requestBookingSaveDto.getBookingGuestsDtoList().size());

        // 3) 게스트별 요금의 총 요금과 예약의 총 요금이 동일해야함
        BigDecimal totalFee = findBookingGuests.stream()
                .map(BookingGuests::getGuestFee)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        assertThat(findBooking.get().getBookingTotalFee()).isEqualTo(totalFee);

        // 4) 재고 1 감소 체크
        assertThat(beforeStock - 1).isEqualTo(afterStock);
    }
}