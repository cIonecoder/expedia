package org.clonecoder.productserver.unit.domain.accommodation;

import org.clonecoder.productserver.domain.AccommodationRoom;
import org.clonecoder.productserver.domain.accommodation.AccommodationService;
import org.clonecoder.productserver.infrastructure.AccommodationRoomRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
@Sql({"classpath:accommodation/schema/accommodation.sql", "classpath:accommodation/data/accommodation_1.sql"})
class AccommodationServiceTest {
    @Autowired
    private AccommodationService accommodationService;

    @Autowired
    private AccommodationRoomRepository accommodationRoomRepository;

    @Test
    void stock() {
        // given
        List<AccommodationRoom> all = accommodationRoomRepository.findAll();
        Long targetIdx = all.get(0).getId();

        // given
        accommodationService.stock(targetIdx);

        // when

    }
}