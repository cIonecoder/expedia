package org.clonecoder.member.interfaces.member.mapper

import org.clonecoder.member.domain.member.MemberCommand
import org.clonecoder.member.interfaces.member.dto.MemberDto


class MemberDtoMapper {

    companion object {
        fun of(request: MemberDto.RegisterRequest): MemberCommand.RegisterMember =
            MemberCommand.RegisterMember(
                email = request.email,
                password = request.password,
            )
    }
}