package org.clonecoder.member.domain.member

import org.clonecoder.member.domain.BaseEntity
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToOne
import javax.persistence.Table

@Table(name = "member_account")
@Entity
class MemberAccount(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column
    val externalId: String = "NONE",

    @Column
    val active: Boolean = true,

    @OneToOne(mappedBy = "memberAccount", fetch = FetchType.LAZY)
    val memberInfo: MemberInfo? = null
): BaseEntity() {

    @Column
    private var email: String = ""

    @Column
    private var password: String = ""

    constructor(email: String, password: String): this() {
        this.email = email
        this.password = password
        this.createdBy = email
        this.lastModifiedBy = email
    }
}