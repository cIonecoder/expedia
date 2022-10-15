package org.clonecoder.auth.interfaces

import org.clonecoder.auth.application.TokenFacade
import org.clonecoder.core.common.response.CommonResponse
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

    @PostMapping("/login")
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