package com.veteran.planai.domain.auth.client.api

import com.veteran.planai.domain.auth.client.request.RefreshTokenRequest
import com.veteran.planai.domain.auth.client.request.SignInRequest
import com.veteran.planai.domain.auth.client.request.SignUpRequest
import com.veteran.planai.domain.auth.service.AuthService
import com.veteran.planai.domain.auth.service.response.JsonWebTokenResponse
import com.veteran.planai.domain.auth.service.response.RefreshTokenResponse
import com.veteran.planai.global.common.dto.response.BaseResponse
import com.veteran.planai.global.common.dto.response.BaseResponseData
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/auth")
class AuthController (
    private val authService: AuthService
) {

    @PostMapping("/sign-up")
    @ResponseStatus(HttpStatus.CREATED)
    fun signUp(@RequestBody @Valid request: SignUpRequest): BaseResponse {
        authService.signUp(request)
        return BaseResponse.created("회원가입 성공")
    }

    @PostMapping("/email")
    fun sendEmail(@RequestParam("email") email: String): BaseResponse {
        return authService.sendEmail(email)
    }

    @PostMapping("/verify-email")
    fun verifyEmail(@RequestParam("email") email: String, @RequestParam("code") code: String): BaseResponse {
        return authService.checkEmail(email, code)
    }

    @PostMapping("/sign-in")
    fun signIn(@RequestBody @Valid request: SignInRequest): BaseResponseData<JsonWebTokenResponse> {
        return BaseResponseData.ok(
            message = "로그인 성공",
            data = authService.signIn(request))
    }

    @PostMapping("/refresh")
    fun refreshToken(@RequestBody @Valid request: RefreshTokenRequest): BaseResponseData<RefreshTokenResponse> {
        return BaseResponseData.ok(
            message = "토큰 재발급 성공",
            data = authService.refresh(request)
        )
    }

}