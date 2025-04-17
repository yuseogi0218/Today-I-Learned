package com.yuseogi.simpleblog.api

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController{

    @GetMapping("/health")
    fun healthTest() :String = "hello kotlin-simple-blog"

}