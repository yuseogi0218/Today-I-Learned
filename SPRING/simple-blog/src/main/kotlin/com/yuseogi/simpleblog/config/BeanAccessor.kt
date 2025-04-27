package com.yuseogi.simpleblog.config

import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import org.springframework.context.annotation.Configuration
import kotlin.reflect.KClass

/**
 * Proxy 객체로 감싸지게 만들지 않음
 */
@Configuration(proxyBeanMethods = false)
class BeanAccessor : ApplicationContextAware {

    private val log = KotlinLogging.logger {  }

    init {
        log.info { "this BeanAccessor => $this" }
    }

    override fun setApplicationContext(applicationContext: ApplicationContext) {
        BeanAccessor.applicationContext = applicationContext
    }

    companion object {
        private lateinit var applicationContext: ApplicationContext

        fun <T: Any> getBean(type: KClass<T>): T {
            return applicationContext.getBean(type.java)
        }

        fun <T: Any> getBean(name: String, type: KClass<T>): T {
            return applicationContext.getBean(name, type.java)
        }
    }
}