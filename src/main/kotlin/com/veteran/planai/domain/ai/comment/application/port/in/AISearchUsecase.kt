package com.veteran.planai.domain.ai.comment.application.port.`in`

import com.veteran.planai.domain.ai.comment.application.dto.enums.FocusMode
import com.veteran.planai.domain.ai.comment.application.dto.response.QnAResponse
import com.veteran.planai.global.common.dto.response.BaseResponseData

interface AISearchUsecase{
    fun search(query: String, mode: FocusMode, planId: Long, chatId: String?) : BaseResponseData<QnAResponse>
}