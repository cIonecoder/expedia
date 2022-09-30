package org.clonecoder.auth.security.token

import com.fasterxml.jackson.databind.ObjectMapper
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.clonecoder.auth.common.properties.JwtProperties
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import java.util.Date

@Component
class JwtTokenProvider(
    private val jwtProperties: JwtProperties,
    private val objectMapper: ObjectMapper
) {

    private val log = LoggerFactory.getLogger(this::class.java)

    // TODO refreshToken 을 redis 에 저장하는 로직 필요
    fun issueTokens(request: TokenCommand.IssueRequest): TokenResponse {
        val payload = objectMapper.writeValueAsString(request)
        return TokenResponse(
            accessToken = issueAccessToken(payload),
            refreshToken = issueRefreshToken(payload),
            email = request.email,
            status = TokenIssueStatus.SUCCESS
        )
    }

    fun issueAccessToken(payload: String): String {
        val now = Date()
        val validity = Date(now.time + jwtProperties.token.accessTokenExpireLength)

        return Jwts.builder()
            .setClaims(createClaims(payload))
            .setIssuedAt(now)
            .setExpiration(validity)
            .signWith(SignatureAlgorithm.HS256, jwtProperties.token.secretKey)
            .compact()
    }

    fun issueRefreshToken(payload: String): String {
        val now = Date()
        val validity = Date(now.time + jwtProperties.token.refreshTokenExpireLength)

        return Jwts.builder()
            .setClaims(createClaims(payload))
            .setIssuedAt(now)
            .setExpiration(validity)
            .signWith(SignatureAlgorithm.HS256, jwtProperties.token.secretKey)
            .compact()
    }

    private fun createClaims(payload: String) = Jwts.claims().setSubject(payload)

    fun getPayload(token: String) = Jwts.parser()
        .setSigningKey(jwtProperties.token.secretKey)
        .parseClaimsJws(token).body.subject

    fun validateToken(token: String): Boolean =
        try {
            val claims = Jwts.parser().setSigningKey(jwtProperties.token.secretKey).parseClaimsJws(token)
            val isNotExpired = !claims.body.expiration.before(Date())
            isNotExpired
        } catch (e: Exception) {
            log.info("Invalid Token")
            false
        }
}