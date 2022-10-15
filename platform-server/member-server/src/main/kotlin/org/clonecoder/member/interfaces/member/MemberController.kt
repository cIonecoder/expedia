package org.clonecoder.member.interfaces.member

import org.clonecoder.member.application.member.MemberFacade
import org.clonecoder.member.common.constant.MEMBER_BASE_URL
import org.clonecoder.member.common.constant.MEMBER_LOGIN
import org.clonecoder.member.interfaces.member.dto.MemberDto
import org.clonecoder.member.interfaces.member.mapper.MemberDtoMapper
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RequestMapping(MEMBER_BASE_URL)
@RestController
class MemberController(
    private val memberFacade: MemberFacade
) {
    @PostMapping
    fun register(
        @RequestBody @Valid request: MemberDto.RegisterRequest
    ) {
        val member = MemberDtoMapper.of(request)
        memberFacade.register(member)
    }

    @PostMapping(MEMBER_LOGIN)
    fun login(
        @RequestBody @Valid request: MemberDto.LoginRequest
    ): MemberDto.LoginResponse {
        val response = memberFacade.login(MemberDtoMapper.of(request))
        return MemberDtoMapper.of(response)
    }
}