package com.expedia.authentication.domain

import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime

abstract class BaseEntity {
    @CreatedDate
    var createdAt: LocalDateTime = LocalDateTime.now()
        private set
    @CreatedBy
    var createdBy: String = SYSTEM_PROPERTY_AUTHOR
        private set
    @LastModifiedDate
    var lastModifiedAt: LocalDateTime = LocalDateTime.now()
        private set
    @LastModifiedBy
    var lastModifiedBy: String = SYSTEM_PROPERTY_AUTHOR
        private set
}

private const val SYSTEM_PROPERTY_AUTHOR = "system"