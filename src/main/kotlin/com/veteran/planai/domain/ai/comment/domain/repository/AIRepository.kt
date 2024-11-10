package com.veteran.planai.domain.ai.comment.domain.repository

import com.veteran.planai.domain.ai.comment.domain.AIEntity
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query

interface AIRepository : MongoRepository<AIEntity, ObjectId>{
    fun findByUserIdOrderByIdAsc(userId: String): List<AIEntity>
    fun findByChatId(chatId: String): List<AIEntity>
    fun deleteByChatId(chatId: String)
    @Query(value = "{ 'planId': ?0 }", fields = "{ 'chatId': 1 }")
    fun findDistinctChatIdsByPlanId(planId: Long): List<String>
}