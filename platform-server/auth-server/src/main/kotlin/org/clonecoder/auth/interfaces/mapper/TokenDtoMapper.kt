package org.clonecoder.auth.interfaces.mapper

import org.clonecoder.auth.interfaces.dto.TokenDto
import org.clonecoder.auth.security.token.TokenCommand
import org.clonecoder.auth.security.token.TokenResponse

class TokenDtoMapper {

    companion object {
        fun of(request: TokenDto.IssueRequest): TokenCommand.IssueRequest =
            TokenCommand.IssueRequest(
                email = request.email,
                password = request.password,
            )

        fun of(response: TokenResponse): TokenDto.Response =
            TokenDto.Response(
                accessToken = response.accessToken,
                refreshToken = response.refreshToken,
                email = response.email,
                status = response.status
            )
    }
}