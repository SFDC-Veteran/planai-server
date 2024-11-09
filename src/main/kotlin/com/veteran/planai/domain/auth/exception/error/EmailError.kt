package com.veteran.planai.domain.auth.exception.error

import com.veteran.planai.global.exception.error.ErrorProperty
import org.springframework.http.HttpStatus

enum class EmailError(
    override val status: HttpStatus,
    override val message: String) : ErrorProperty {

    UNABLE_TO_SEND(HttpStatus.BAD_REQUEST, "이메일을 보낼 수 없습니다 :< "),
    EMAIL_CONFLICT(HttpStatus.CONFLICT,"이미 존재하는 이메일입니다 :[ "),
    EMAIL_NOT_VERIFY(HttpStatus.BAD_REQUEST, "인증코드가 옳지 않습니다 :( "),
    EMAIL_NOT_FOUND(HttpStatus.NOT_FOUND, "니꺼 DB에 없써 :( ");

}