package org.clonecoder.productserver.domain.accommodation;

import org.clonecoder.productserver.domain.AccommodationRoom;

public interface AccommodationStore {
    AccommodationRoom getAccommodationRoom(Long accommodationRoomId);
}
