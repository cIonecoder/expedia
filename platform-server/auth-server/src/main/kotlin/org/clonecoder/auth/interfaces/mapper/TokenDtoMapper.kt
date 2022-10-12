package org.clonecoder.auth.interfaces.mapper

import org.clonecoder.auth.interfaces.dto.TokenDto
import org.clonecoder.auth.security.token.TokenCommand
import org.clonecoder.auth.security.token.TokenResponse

class TokenDtoMapper {

    companion object {
        fun of(request: TokenDto.IssueRequest): TokenCommand.IssueRequest =
            TokenCommand.IssueRequest(email = request.email)

        fun of(request: TokenDto.PatchRequest): TokenCommand.PatchRequest =
            TokenCommand.PatchRequest(
                accessToken = request.accessToken,
                refreshToken = request.refreshToken
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