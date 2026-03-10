package io.dodn.commerce.core.domain

/**
 * QnA 가 주요 개념이며, Question 과 Answer 로 구성된다.
 */
data class QnA(
    // 질문에 대한 비공개 처리 로직이 있는지
    // 비회원도 질문을 작성할 수 있는지
    val question: Question,
    // 대댓글을 작성할 수 있는 구조인지
    // 또는, 작성자와 답변자가 ping-pong 을 할 수 있는 구조인지
    val answer: Answer,
)
