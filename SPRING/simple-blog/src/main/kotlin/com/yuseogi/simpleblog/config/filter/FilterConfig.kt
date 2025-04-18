package com.yuseogi.simpleblog.config.filter

import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FilterConfig {

//    @Bean
    fun registerMyAuthenticationFilter(): FilterRegistrationBean<MyAuthenticationFilter> {

        val bean = FilterRegistrationBean(MyAuthenticationFilter())

        bean.addUrlPatterns("/api/*")
        bean.order = 0
        return bean
    }

}