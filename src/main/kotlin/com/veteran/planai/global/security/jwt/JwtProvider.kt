package com.veteran.planai.global.security.jwt

import com.veteran.planai.domain.user.domain.enum.UserRole
import com.veteran.planai.global.security.jwt.config.JwtProperties
import io.jsonwebtoken.Jwts
import org.springframework.stereotype.Component
import java.nio.charset.StandardCharsets
import java.util.*
import javax.crypto.SecretKey
import javax.crypto.spec.SecretKeySpec

@Component
class JwtProvider (private val jwtProperties: JwtProperties){

    private val secretKey: SecretKey = SecretKeySpec(
        this.jwtProperties.secretKey.toByteArray(StandardCharsets.UTF_8),
        Jwts.SIG.HS256.key().build().algorithm
    )

    fun generateAccessToken(id: String, userRole: UserRole): String {
        return Jwts.builder()
            .claim("id",id)
            .claim("authority", userRole)
            .issuedAt(Date(System.currentTimeMillis()))
            .expiration(Date(System.currentTimeMillis() + jwtProperties.expiration))
            .signWith(secretKey)
            .compact()
    }

    fun generateRefreshToken(id: String, userRole: UserRole): String {
        return Jwts.builder()
            .claim("id",id)
            .claim("authority", userRole)
            .issuedAt(Date(System.currentTimeMillis()))
            .expiration(Date(System.currentTimeMillis() + jwtProperties.refreshExpiration))
            .signWith(secretKey)
            .compact()
    }
}