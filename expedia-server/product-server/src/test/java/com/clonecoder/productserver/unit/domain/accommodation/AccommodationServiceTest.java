package com.clonecoder.productserver.unit.domain.accommodation;

import com.clonecoder.productserver.domain.Accommodation;
import com.clonecoder.productserver.domain.AccommodationRoom;
import com.clonecoder.productserver.domain.accommodation.AccommodationService;
import com.clonecoder.productserver.infrastructure.AccommodationRoomRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
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