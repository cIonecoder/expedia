package org.clonecoder.member.infrastructure.adapter.auth

import org.clonecoder.member.common.exception.IssueTokenException
import org.clonecoder.member.common.properties.AdapterProperties
import org.clonecoder.member.domain.member.adapter.AuthAdapter
import org.clonecoder.member.domain.member.adapter.AuthApiCallerDto
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient

@Component
class AuthAdapterImpl(
    private val webClient: WebClient,
    private val adapterProperties: AdapterProperties
): AuthAdapter {

    private val log = LoggerFactory.getLogger(this::class.java)

    override fun issueTokens(request: AuthApiCallerDto.IssueTokensRequest): AuthApiCallerDto.IssueTokensResponse {
        val response = runCatching {
            webClient
                .mutate()
                .build()
                .post()
                .uri {
                    it.scheme("http")
                        .host(adapterProperties.authServer.host)
                        .port(adapterProperties.authServer.port)
                        .path(adapterProperties.authServer.issueTokenPath).build()
                }
                .bodyValue(request)
                .retrieve()
                .bodyToMono(AuthApiCallerDto.IssueTokensResponse::class.java)
                .block()
        }.onFailure {
            log.error("# Fail to IssueTokens: $it")
        }

        return response.getOrNull() ?: throw IssueTokenException()
    }
}