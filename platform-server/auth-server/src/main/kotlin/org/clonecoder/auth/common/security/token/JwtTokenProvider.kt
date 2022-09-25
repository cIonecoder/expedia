package org.clonecoder.auth.common.security.token

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.clonecoder.auth.common.properties.JwtProperties
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import java.util.Date

@Component
class JwtTokenProvider(
    private val jwtProperties: JwtProperties
) {

    private val log = LoggerFactory.getLogger(this::class.java)

    fun createToken(payload: String): String {
        val claims = Jwts.claims().setSubject(payload)
        val now = Date()
        val validity = Date(now.time + jwtProperties.token.expireLength)

        return Jwts.builder()
            .setClaims(claims)
            .setIssuedAt(now)
            .setExpiration(validity)
            .signWith(SignatureAlgorithm.HS256, jwtProperties.token.secretKey)
            .compact()
    }

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