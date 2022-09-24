package org.clonecoder.auth.domain.user

import org.clonecoder.auth.domain.BaseEntity
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.OneToOne
import javax.persistence.Table

@Table(name = "user_info")
@Entity
class UserInfo(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @JoinColumn(name = "account_id")
    @OneToOne(fetch = FetchType.LAZY)
    val userAccount: UserAccount,

    @Column
    val lastName: String,

    @Column
    val firstName: String,

    @Column
    val birthYear: String,

    @Column
    val birthMonth: String,

    @Column
    val birthDate: String,

    @Enumerated(EnumType.STRING)
    @Column
    val gender: Gender,

    @Column
    val phoneCountryCode: String,

    @Column
    val phone: String,

    @Column
    val emergencyPhoneCountryCode: String,

    @Column
    val emergencyPhone: String
): BaseEntity() {
}

enum class Gender {
    M, W
}