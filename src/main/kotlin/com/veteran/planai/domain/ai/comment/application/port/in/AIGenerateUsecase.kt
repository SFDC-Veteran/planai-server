package com.veteran.planai.domain.ai.comment.application.port.`in`

import com.veteran.planai.domain.ai.comment.application.dto.response.QnAResponse
import com.veteran.planai.global.common.dto.response.BaseResponseData

interface AIGenerateUsecase {
    fun generateUIUX(): BaseResponseData<QnAResponse>
}