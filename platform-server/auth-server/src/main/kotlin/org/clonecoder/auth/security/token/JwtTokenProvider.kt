package org.clonecoder.auth.security.token

import com.fasterxml.jackson.databind.ObjectMapper
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.clonecoder.auth.common.redis.RedisClient
import org.clonecoder.auth.common.properties.JwtProperties
import org.clonecoder.auth.common.redis.RFK_CACHE_NAME
import org.clonecoder.auth.common.redis.RFK_KEY
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import java.util.Date
import java.util.concurrent.TimeUnit

@Component
class JwtTokenProvider(
    private val redisClient: RedisClient,
    private val jwtProperties: JwtProperties,
    private val objectMapper: ObjectMapper
) {

    private val log = LoggerFactory.getLogger(this::class.java)

    fun issueTokens(request: TokenIssueSpec): TokenResponse {
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
        val validity = Date(now.time + jwtProperties.token.accessTokenExpireTime)

        return Jwts.builder()
            .setClaims(createClaims(payload))
            .setIssuedAt(now)
            .setExpiration(validity)
            .signWith(SignatureAlgorithm.HS256, jwtProperties.token.secretKey)
            .compact()
    }

    fun issueRefreshToken(payload: String): String {
        val now = Date()
        val expireTime = jwtProperties.token.refreshTokenExpireTime
        val validity = Date(now.time + expireTime)

        val refreshToken = Jwts.builder()
            .setClaims(createClaims(payload))
            .setIssuedAt(now)
            .setExpiration(validity)
            .signWith(SignatureAlgorithm.HS256, jwtProperties.token.secretKey)
            .compact()

        redisClient.set(
            cacheName = RFK_CACHE_NAME,
            key = RFK_KEY + payload,
            value = refreshToken,
            expireTime = expireTime,
            timeUnit = TimeUnit.MILLISECONDS
        )

        return refreshToken
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