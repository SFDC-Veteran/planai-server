package com.veteran.planai.domain.ai.comment.application.port.`in`

import com.veteran.planai.domain.ai.comment.application.dto.request.SearchRequest
import com.veteran.planai.domain.ai.comment.application.dto.response.SearchResponse
import com.veteran.planai.global.common.dto.response.BaseResponseData

interface AISearchUsecase{
    fun search(searchRequest: SearchRequest) : BaseResponseData<SearchResponse>
}