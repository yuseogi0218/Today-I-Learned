package io.dodn.commerce.core.domain

import io.dodn.commerce.core.enums.EntityStatus
import io.dodn.commerce.core.support.OffsetLimit
import io.dodn.commerce.core.support.Page
import io.dodn.commerce.core.support.error.CoreException
import io.dodn.commerce.core.support.error.ErrorType
import io.dodn.commerce.storage.db.core.AnswerRepository
import io.dodn.commerce.storage.db.core.QuestionEntity
import io.dodn.commerce.storage.db.core.QuestionRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

/**
 * Component (Finder, Writer) 로 분리시키지 않은 이유 -> 현재 정책 및 Logic 이 간단하기 때문에.
 * - But, 코드에 통일성이 없기 때문에, 유지보수에는 안좋을 수 있다.
 */
@Service
class QnAService(
    private val questionRepository: QuestionRepository,
    private val answerRepository: AnswerRepository,
) {
    fun findQnA(productId: Long, offsetLimit: OffsetLimit): Page<QnA> {
        val questions = questionRepository.findByProductIdAndStatus(
            productId,
            EntityStatus.ACTIVE,
            offsetLimit.toPageable(),
        )

        val answers = answerRepository.findByQuestionIdIn(questions.content.map { it.id })
            .filter { it.isActive() }
            .associateBy { it.questionId }

        // Question 과 Answer 를 한 쌍으로, QnA 를 구성한다.
        return Page(
            questions.content.map {
                QnA(
                    question = Question(
                        id = it.id,
                        userId = it.userId,
                        title = it.title,
                        content = it.content,
                    ),
                    answer = answers[it.id]?.let { answer ->
                        Answer(answer.id, answer.adminId, answer.content)
                    } ?: Answer.EMPTY,
                )
            },
            questions.hasNext(),
        )
    }

    @Transactional
    fun addQuestion(user: User, productId: Long, content: QuestionContent): Long {
        val saved = questionRepository.save(
            QuestionEntity(
                userId = user.id,
                productId = productId,
                title = content.title,
                content = content.content,
            ),
        )
        return saved.id
    }

    @Transactional
    fun updateQuestion(user: User, questionId: Long, content: QuestionContent): Long {
        val found = questionRepository.findByIdAndUserId(questionId, user.id)?.takeIf { it.isActive() } ?: throw CoreException(ErrorType.NOT_FOUND_DATA)
        found.updateContent(content.title, content.content)
        return found.id
    }

    @Transactional
    fun removeQuestion(user: User, questionId: Long): Long {
        val found = questionRepository.findByIdAndUserId(questionId, user.id)?.takeIf { it.isActive() } ?: throw CoreException(ErrorType.NOT_FOUND_DATA)
        found.delete()
        return found.id
    }

    /**
     * NOTE: 답변은어드민 쪽 기능임
     * fun addAnswer(user: User, questionId: Long, content: String): Long {...}
     * fun updateAnswer(user: User, answerId: Long, content: String): Long {...}
     * fun removeAnswer(user: User, answerId: Long): Long {...}
     */
}
