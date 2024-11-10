package com.veteran.planai.domain.ai.comment.application.dto

import com.veteran.planai.domain.ai.comment.application.dto.model.Source

data class AIComment(
    val id: String,
    val message: String,
    val question: String,
    val sources: List<Source>? = null,
    val userId: String,
    val planId: Long,
    val chatId: String,
)