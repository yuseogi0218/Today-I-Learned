package com.yuseogi.simpleblog.config.aop

import io.github.oshai.kotlinlogging.KotlinLogging

object CustomAopObject {

    private val log = KotlinLogging.logger {  }

    /**
     * 일급 시민의 조건 (코틀린에서 함수도 일급 시민이다. -> 자바에서는 클래스만 일급 시민이다.)
     * 1. 인자로 넘겨줄 수 있다.
     * 2. 리턴 타입으로 정의할 수 있다.
     * 3. 값에 해당할 수 있다.
     *
     * 고차 함수를 통해서, AOP 구현 방법
     */

    // 함수의 마지막 인자가 function 일 경우에 -> 함수형 인터페이스를 만들어서 넘겨줄 수 있다.
    fun highOrderFunc(func: () ->Unit) {
        log.info { "before" }
        func()
        log.info { "after" }
    }
}

fun main() {
    doSomething()
}

fun doSomething() = CustomAopObject.highOrderFunc {
    println("do something")
}