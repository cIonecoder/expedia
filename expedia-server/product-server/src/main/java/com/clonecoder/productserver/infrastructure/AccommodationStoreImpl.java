package com.clonecoder.productserver.infrastructure;

import com.clonecoder.productserver.domain.accommodation.AccommodationStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccommodationStoreImpl implements AccommodationStore {
    private final AccommodationRepository accommodationRepository;
    private final AccommodationRoleRepository accommodationRoleRepository;
    private final AccommodationRoomRepository accommodationRoomRepository;
    private final AccommodationRoomInfoRepository accommodationRoomInfoRepository;
    private final AccommodationRoomFeeRepository accommodationRoomFeeRepository;
}
