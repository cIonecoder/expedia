package org.clonecoder.member.domain.member

import org.clonecoder.member.domain.BaseEntity
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

@Table(name = "member_info")
@Entity
class MemberInfo(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @JoinColumn(name = "account_id")
    @OneToOne(fetch = FetchType.LAZY)
    val memberAccount: MemberAccount,

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