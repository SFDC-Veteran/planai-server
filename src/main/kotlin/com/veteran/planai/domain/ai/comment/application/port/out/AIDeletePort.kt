package com.veteran.planai.domain.ai.comment.application.port.out

import org.bson.types.ObjectId

interface AIDeletePort {
    fun deleteById(id: ObjectId)
    fun deleteByChatId(chatId: String)
}