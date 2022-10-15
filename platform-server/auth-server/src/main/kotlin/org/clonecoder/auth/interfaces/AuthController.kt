package org.clonecoder.auth.interfaces

import org.clonecoder.auth.application.TokenFacade
import org.clonecoder.auth.common.response.CommonResponse
import org.clonecoder.auth.interfaces.dto.TokenDto
import org.clonecoder.auth.interfaces.mapper.TokenDtoMapper
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/auth")
@RestController
class AuthController(
    private val tokenFacade: TokenFacade
) {

    // TODO 회원 로그인 -> 인증 서버 토큰 생성 이 맞을지, 인증 로그인 -> 회원이 맞을지
    // 현재 해당 api 는 별다른 검증을 거치치 않으므로 email 만 넘기면 바로 토큰을 생성해 줌
    // 로그인 api 를 인증서버에 넣는게 맞는지, 회원에 넣는게 맞는지 고민...
    // 인증이 -> 회원을 의존하고 있게 하고 인증서버에서 로그인을 가지고 있는게 맞을 것 같긴함
    @PostMapping("/token")
    fun issueToken(@RequestBody request: TokenDto.IssueRequest): CommonResponse<TokenDto.Response> {
        val response = tokenFacade.issueTokens(TokenDtoMapper.of(request))
        return CommonResponse.success(TokenDtoMapper.of(response))
    }

    @PutMapping("/token")
    fun patchToken(@RequestBody request: TokenDto.PatchRequest): CommonResponse<TokenDto.Response> {
        val response = tokenFacade.patchTokens(TokenDtoMapper.of(request))
        return CommonResponse.success(TokenDtoMapper.of(response))
    }
}