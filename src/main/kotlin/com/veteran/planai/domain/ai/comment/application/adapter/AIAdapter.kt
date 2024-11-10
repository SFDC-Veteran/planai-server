package com.veteran.planai.domain.ai.comment.application.adapter

import com.veteran.planai.domain.ai.comment.application.port.out.AIDeletePort
import com.veteran.planai.domain.ai.comment.application.port.out.AIFindPort
import com.veteran.planai.domain.ai.comment.application.port.out.AISavePort
import com.veteran.planai.domain.ai.comment.domain.AIEntity
import com.veteran.planai.domain.ai.comment.domain.repository.AIRepository
import org.bson.types.ObjectId
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class AIAdapter(
    private val aiRepository: AIRepository,
): AISavePort, AIFindPort, AIDeletePort {

    @Transactional
    override fun save(entity: AIEntity) {
        aiRepository.save(entity)
    }

//    @Transactional
//    override fun findByUserId(userId: String): List<AIEntity> {
//        return aiRepository.findByUserIdOrderByIdAsc(userId)
//    }

    @Transactional
    override fun findByChatId(chatId: String): List<AIEntity> {
        return aiRepository.findByChatId(chatId)
    }

    @Transactional
    override fun findByPlanId(planId: Long): List<String> {
        return aiRepository.findDistinctChatIdsByPlanId(planId)
    }

    @Transactional
    override fun deleteByChatId(chatId: String) {
        return aiRepository.deleteByChatId(chatId)
    }

    @Transactional
    override fun deleteById(id: ObjectId) {
        aiRepository.deleteById(id)
    }

}