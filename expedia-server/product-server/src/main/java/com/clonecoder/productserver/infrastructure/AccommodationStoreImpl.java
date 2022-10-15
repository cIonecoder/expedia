package com.clonecoder.productserver.infrastructure;

import com.clonecoder.productserver.domain.AccommodationRoom;
import com.clonecoder.productserver.domain.accommodation.AccommodationStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccommodationStoreImpl implements AccommodationStore {
    private final AccommodationRoomRepository accommodationRoomRepository;

    @Override
    public AccommodationRoom getAccommodationRoom(Long accommodationRoomId) {
        return accommodationRoomRepository.findById(accommodationRoomId).get();
    }
}
