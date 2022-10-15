package org.clonecoder.productserver.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class AccommodationRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accommodation_id")
    private Accommodation accommodation;

    private String progStatusCd;
    private String stoppedDts;
    private String stoppedRsn;

    private String lastModifiedBy;
    private LocalDateTime lastModifiedAt;
    private String createdBy;
    private LocalDateTime createdAt;
}
