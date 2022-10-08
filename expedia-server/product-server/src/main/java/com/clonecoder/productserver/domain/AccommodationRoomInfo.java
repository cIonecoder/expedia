package com.clonecoder.productserver.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class AccommodationRoomInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accommodation_room_id")
    private AccommodationRoom accommodationRoom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accommodation_common_code_id")
    private AccommodationCommonCode accommodationCommonCode;

    private int active;

    private String lastModifiedBy;
    private LocalDateTime lastModifiedAt;
    private String createdBy;
    private LocalDateTime createdAt;
}
