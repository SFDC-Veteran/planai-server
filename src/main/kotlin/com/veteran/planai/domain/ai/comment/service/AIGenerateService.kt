package com.veteran.planai.domain.ai.comment.service

import com.veteran.planai.domain.ai.comment.application.dto.response.QnAResponse
import com.veteran.planai.domain.ai.comment.application.port.`in`.AIGenerateUsecase
import com.veteran.planai.global.common.dto.response.BaseResponseData
import org.springframework.stereotype.Service

@Service
class AIGenerateService: AIGenerateUsecase {
    override fun generateUIUX(): BaseResponseData<QnAResponse> {
        TODO("Not yet implemented")
    }
}