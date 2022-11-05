package org.clonecoder.productserver.domain.accommodation;

public interface AccommodationStore {
    void stockDecrease(Long accommodationRoomId);
}
