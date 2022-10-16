package org.clonecoder.productserver.infrastructure;

import org.clonecoder.productserver.domain.AccommodationRoom;
import org.clonecoder.productserver.domain.accommodation.AccommodationStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccommodationStoreImpl implements AccommodationStore {
    private final AccommodationRoomRepository accommodationRoomRepository;

    @Override
    public AccommodationRoom getAccommodationRoom(Long accommodationRoomId) {
        return accommodationRoomRepository.findById(accommodationRoomId).get();
    }
}
