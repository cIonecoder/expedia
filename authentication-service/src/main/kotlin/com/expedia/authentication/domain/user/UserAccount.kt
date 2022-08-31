package com.expedia.authentication.domain.user

import com.expedia.authentication.domain.BaseEntity
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToOne
import javax.persistence.Table

@Table(name = "user_account")
@Entity
class UserAccount(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column
    val email: String,

    @Column
    val password: String,

    @Column
    val externalId: String,

    @Column
    val active: Boolean = true,

    @OneToOne(mappedBy = "userAccount", fetch = FetchType.LAZY)
    val userInfo: UserInfo? = null
): BaseEntity() {
}