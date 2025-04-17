package com.yuseogi.simpleblog.util.value

data class CmResDto<T>(
    val resultCode: T,
    val resultMsg: String,
    val data: T
)