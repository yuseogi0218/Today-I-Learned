package com.yuseogi.simpleblog.exception

import com.fasterxml.jackson.annotation.JsonFormat

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
enum class ErrorCode(
    val code: String,
    val message: String
) {

    INVALID_INPUT_VALUE("C001", " invalid input value"),
    ENTITY_NOT_FOUND("C002", "Entity not found"),
    INTERNAL_SERVER_ERROR("C003", "Internal Server Error")
}