package com.veteran.planai.domain.ai.comment.application.port.out

import com.veteran.planai.domain.ai.comment.domain.AIEntity

interface AISavePort {
    fun save(entity: AIEntity)
}