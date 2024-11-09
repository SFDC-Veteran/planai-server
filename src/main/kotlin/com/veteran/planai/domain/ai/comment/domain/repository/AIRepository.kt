package com.veteran.planai.domain.ai.comment.domain.repository

import com.veteran.planai.domain.ai.comment.domain.AIEntity
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface AIRepository : MongoRepository<AIEntity, String>{
    fun findByUserIdOrderByIdAsc(userId: String): List<AIEntity>
    fun deleteById(id: ObjectId)
    fun findByChatId(chatId: ObjectId): List<AIEntity>
    fun deleteByChatId(chatId: ObjectId)
    fun findByPlanId(planId: Long): List<AIEntity>
}