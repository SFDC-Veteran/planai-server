package com.veteran.planai.domain.user.client.api

import com.veteran.planai.domain.user.client.dto.Profile
import com.veteran.planai.domain.user.client.dto.request.UserEditRequest
import com.veteran.planai.domain.user.usecase.UserUseCase
import com.veteran.planai.global.common.dto.response.BaseResponse
import com.veteran.planai.global.common.dto.response.BaseResponseData
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class UserController(
    private val userUseCase: UserUseCase,
) {

    @PostMapping
    fun editUser(@RequestBody request: UserEditRequest): BaseResponse {
        userUseCase.editUser(request)
        return BaseResponse.ok("유저 정보 수정 완료")
    }

    @DeleteMapping
    fun deleteUser(): BaseResponse {
        userUseCase.deleteUser()
        return BaseResponse.ok(message = "회원탈퇴 완료")
    }

    @GetMapping("/profile")
    fun getUserProfile(): BaseResponseData<Profile> {
        return BaseResponseData.ok(userUseCase.getUserProfile(), "조회 성공")
    }

}

