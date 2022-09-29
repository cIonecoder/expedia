package org.clonecoder.member.interfaces.member

import org.clonecoder.member.interfaces.member.dto.MemberDto
import org.clonecoder.member.interfaces.member.mapper.MemberDtoMapper
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RequestMapping("/members")
@RestController
class MemberController(
    private val memberFacade: org.clonecoder.member.application.member.MemberFacade
) {
    @PostMapping
    fun register(
        @RequestBody @Valid request: MemberDto.RegisterRequest
    ) {
        val member = MemberDtoMapper.of(request)
        memberFacade.register(member)
    }
}