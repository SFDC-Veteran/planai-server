package com.veteran.planai.domain.ai.comment.application.dto.response

import com.veteran.planai.domain.ai.comment.application.dto.model.Source

data class SearchResponse(
    val message: String,
    val sources: List<Source>? = null
)