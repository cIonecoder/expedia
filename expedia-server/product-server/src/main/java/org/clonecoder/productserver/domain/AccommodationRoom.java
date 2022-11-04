package org.clonecoder.productserver.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.clonecoder.coreserver.common.enums.ExceptionMessage;
import org.clonecoder.coreserver.common.exception.BadRequestException;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class AccommodationRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accommodation_id")
    private Accommodation accommodation;

    private String roomType;
    private String roomName;
    private int maxEntranceCnt;
    private int stock;

    private String lastModifiedBy;
    private LocalDateTime lastModifiedAt;
    private String createdBy;
    private LocalDateTime createdAt;

    /**
     * 재고 감소
     */
    public void stockDecrease() {
        if (this.stock < 1) {
            throw new BadRequestException(ExceptionMessage.NOT_ENOUGH_ACCOMMODATION_ROOM_STOCK);
        }
        this.stock = this.stock - 1;
    }
}
