package com.veteran.planai.domain.ai.comment.exception

import com.veteran.planai.global.exception.error.ErrorProperty
import org.springframework.http.HttpStatus

enum class AIError(
    override val status: HttpStatus,
    override val message: String) : ErrorProperty {

        CHAT_NOT_FOUND(HttpStatus.NOT_FOUND, "유저를 찾을 수 없거나 채팅을 찾을 수 없습니다 :("),

}