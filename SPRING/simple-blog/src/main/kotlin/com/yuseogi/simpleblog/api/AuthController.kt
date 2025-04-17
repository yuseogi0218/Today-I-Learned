package com.yuseogi.simpleblog.api

import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/auth")
@RestController
class AuthController() {

    val log = KotlinLogging.logger {  }

    @PostMapping("/login")
    fun login() {

    }

}