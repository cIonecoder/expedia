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

        fun of(request: MemberDto.LoginRequest): MemberCommand.LoginRequest =
            MemberCommand.LoginRequest(
                email = request.email,
                password = request.password,
            )

        fun of(response: MemberCommand.LoginResponse): MemberDto.LoginResponse =
            MemberDto.LoginResponse(
                accessToken = response.accessToken,
                refreshToken = response.refreshToken
            )
    }
}