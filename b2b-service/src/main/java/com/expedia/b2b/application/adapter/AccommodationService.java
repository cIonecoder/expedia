package com.expedia.b2b.application.adapter;

import com.expedia.b2b.domain.*;
import org.springframework.stereotype.Service;

/**
 * Adapter Service
 */
@Service
public interface AccommodationService {
    void saveAccommodation(Accommodation accommodation);
    void saveAccommodationRole(AccommodationRole accommodationRole);
    void saveAccommodationRoom(AccommodationRoom accommodationRoom);
    void saveAccommodationRoomInfo(AccommodationRoomInfo accommodationRoomInfo);
    void saveAccommodationRoomFee(AccommodationRoomFee accommodationRoomFee);
}
