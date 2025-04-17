package com.yuseogi.simpleblog.config.aop

import io.github.oshai.kotlinlogging.KotlinLogging
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.AfterReturning
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.aspectj.lang.annotation.Pointcut
import org.springframework.stereotype.Component
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes

@Component
@Aspect
class LoggerAspect {

    val log = KotlinLogging.logger {  }

    // Controller 의 모든 메서드 타겟
    @Pointcut("execution(* com.yuseogi.simpleblog.api.*Controller.*(..))")
    private fun controllerCut() = Unit

    @Before("controllerCut()")
    fun beforeControllerLoggerAdvice(joinPoint: JoinPoint) {
        val typeName = joinPoint.signature.declaringTypeName
        val methodName = joinPoint.signature.name

        val request = (RequestContextHolder.currentRequestAttributes() as ServletRequestAttributes).request

        log.info {
            """
                
            request url: ${request.servletPath}
            type: $typeName
            method: $methodName
                
            """.trimIndent()
        }
    }

    @AfterReturning(pointcut = "controllerCut()", returning = "result")
    fun afterControllerLoggerAdvice(joinPoint: JoinPoint, result: Any) {

        log.info { """
            
            ${joinPoint.signature.name}
            Method return value: $result 
            
        """.trimIndent() }

    }
}