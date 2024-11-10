package com.veteran.planai.domain.plan.exception

import com.veteran.planai.global.exception.error.ErrorProperty
import org.springframework.http.HttpStatus

enum class PlanError(
    override val message: String,
    override val status: HttpStatus
): ErrorProperty {
    PLAN_NOT_FOUND("유저에 해당하는 기획서가 없습니다.", HttpStatus.NOT_FOUND),
//    PLAN_CONFLICT("기획서 제목은 타 기획서와 중복 될 수 없습니다.", HttpStatus.BAD_REQUEST),
    PLAN_CANNOT_DELETE("본인이 작성한 기획서만 삭제 할 수 있습니다.", HttpStatus.BAD_REQUEST),
}