package org.clonecoder.auth.interfaces

import org.clonecoder.auth.application.TokenFacade
import org.clonecoder.auth.security.token.JwtTokenProvider
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

    @PostMapping("/token")
    fun issueToken(@RequestBody request: TokenDto.IssueRequest): TokenDto.Response {
        val response = tokenFacade.issueTokens(TokenDtoMapper.of(request))
        return TokenDtoMapper.of(response)
    }

    @PutMapping("/token")
    fun patchToken(@RequestBody request: TokenDto.PatchRequest): TokenDto.Response {
        val response = tokenFacade.patchTokens(TokenDtoMapper.of(request))
        return TokenDtoMapper.of(response)
    }
}