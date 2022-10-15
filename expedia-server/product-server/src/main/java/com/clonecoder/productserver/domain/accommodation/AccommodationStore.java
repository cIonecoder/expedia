package com.clonecoder.productserver.domain.accommodation;

import com.clonecoder.productserver.domain.AccommodationRoom;

public interface AccommodationStore {
    AccommodationRoom getAccommodationRoom(Long accommodationRoomId);
}
