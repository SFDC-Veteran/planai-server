package com.veteran.planai.domain.auth.service

import com.veteran.planai.domain.auth.client.request.RefreshTokenRequest
import com.veteran.planai.domain.auth.client.request.SignInRequest
import com.veteran.planai.domain.auth.client.request.SignUpRequest
import com.veteran.planai.domain.auth.service.response.JsonWebTokenResponse
import com.veteran.planai.domain.auth.service.response.RefreshTokenResponse
import com.veteran.planai.domain.user.client.dto.User
import com.veteran.planai.domain.user.domain.enum.UserRole
import com.veteran.planai.domain.user.domain.repository.jpa.UserJpaRepository
import com.veteran.planai.domain.user.exception.PasswordWrongException
import com.veteran.planai.domain.user.exception.UserExistException
import com.veteran.planai.domain.user.exception.UserNotFoundException
import com.veteran.planai.global.common.dto.response.BaseResponse
import com.veteran.planai.global.common.dto.response.BaseResponseData
import com.veteran.planai.global.security.jwt.JwtExtract
import com.veteran.planai.global.security.jwt.JwtProvider
import com.veteran.planai.global.security.jwt.exception.TokenExpiredException
import com.veteran.planai.global.security.jwt.exception.error.JwtErrorType
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class AuthService (
    private val userJpaRepository: UserJpaRepository,
    private val encoder: PasswordEncoder,
    private val jwtProvider: JwtProvider,
    private val jwtExtract: JwtExtract,
    private val emailUtil: EmailUtil
) {

    fun signUp(request: SignUpRequest) {
        if(userJpaRepository.existsById(request.id)) {
            throw UserExistException.EXCEPTION
        }
        save(request)
    }

    fun sendEmail(email: String): BaseResponse {
        emailUtil.sendVerificationCodeToEmail(email)
        return BaseResponse.ok("이메일 전송 완료")
    }

    fun checkEmail(email: String, code: String): BaseResponse {
        return BaseResponse.ok(emailUtil.verifyCode(email, code))
    }

    fun signIn(request: SignInRequest): JsonWebTokenResponse {
        val user: User = userJpaRepository
            .findById(request.id)
            .map { userEntity -> User.toUser(userEntity) }
            .orElseThrow { UserNotFoundException.EXCEPTION }
        val password: String = user.password
        if (!encoder.matches(request.password, password))
            throw PasswordWrongException.EXCEPTION
        return JsonWebTokenResponse(
            accessToken = jwtProvider.generateAccessToken(request.id, user.userRole),
            refreshToken = jwtProvider.generateRefreshToken(request.id, user.userRole),
            )
    }

    fun refresh(request: RefreshTokenRequest): RefreshTokenResponse {
        val got = jwtExtract.getToken(request.refreshToken)
        val user = jwtExtract.findUserById(got)
        if (jwtExtract.checkTokenInfo(got) == JwtErrorType.ExpiredJwtException) {
            throw TokenExpiredException.EXCEPTION
        }
        return RefreshTokenResponse(
                jwtProvider.generateAccessToken(user.id, user.userRole),
            )
    }

    fun save(request: SignUpRequest){
        userJpaRepository.save(
            User.toEntity(
                User(
            id = request.id,
            name = request.name,
            password = encoder.encode(request.password),
            userRole = UserRole.USER,
        )
            ))
    }

}