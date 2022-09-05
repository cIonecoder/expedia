package com.expedia.authentication.domain

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.LastModifiedBy
import java.time.ZonedDateTime

abstract class BaseEntity {
    @CreationTimestamp
    var createdAt: ZonedDateTime = ZonedDateTime.now()
        private set
    @CreatedBy
    var createdBy: String = SYSTEM_PROPERTY_AUTHOR
        private set
    @UpdateTimestamp
    var lastModifiedAt: ZonedDateTime = ZonedDateTime.now()
        private set
    @LastModifiedBy
    var lastModifiedBy: String = SYSTEM_PROPERTY_AUTHOR
        private set
}

private const val SYSTEM_PROPERTY_AUTHOR = "system"