package com.yuseogi.simpleblog.config.security

import com.fasterxml.jackson.databind.ObjectMapper
import com.yuseogi.simpleblog.domain.member.MemberRepository
import com.yuseogi.simpleblog.util.func.responseData
import com.yuseogi.simpleblog.util.value.CmResDto
import io.github.oshai.kotlinlogging.KotlinLogging
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpStatus
import org.springframework.security.access.AccessDeniedException
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer
import org.springframework.security.config.annotation.web.invoke
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.core.Authentication
import org.springframework.security.core.AuthenticationException
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.AuthenticationEntryPoint
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.access.AccessDeniedHandler
import org.springframework.security.web.authentication.AuthenticationFailureHandler
import org.springframework.security.web.authentication.AuthenticationSuccessHandler
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
class SecurityConfig(
    private val authenticationConfiguration: AuthenticationConfiguration,
    private val objectMapper: ObjectMapper
) {

    private val log = KotlinLogging.logger {  }

//    @Bean
    fun webSecurityCustomizer(): WebSecurityCustomizer? {
        return WebSecurityCustomizer { web: WebSecurity -> web.ignoring().requestMatchers("/**") }
    }

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http {
            csrf {
                disable()
            }
            headers {
                frameOptions {
                    disable()
                }
            }
            formLogin {
                disable()
            }
            httpBasic {
                disable()
            }
            sessionManagement {
                sessionCreationPolicy = SessionCreationPolicy.STATELESS
            }
            cors {
                configurationSource = corsConfig()
            }
            authorizeHttpRequests {
                authorize("/v1/posts", hasAnyRole("ADMIN", "USER"))
//                authorize("/v1/member/profile", hasAnyRole("ADMIN", "USER"))
                authorize(anyRequest, permitAll)
            }
            exceptionHandling {
                authenticationEntryPoint = CustomAuthenticationEntryPoint(objectMapper)
                accessDeniedHandler = CustomAccessDeniedHandler()
            }
            logout {
                logoutUrl = "/logout"
                logoutSuccessHandler = CustomLogoutSuccessHandler(objectMapper)
            }
        }

        http
            .addFilter(loginFilter())
            .addFilter(authenticationFilter())

        return http.build()
    }

    @Bean
    fun authenticationManager(): AuthenticationManager {
        return authenticationConfiguration.authenticationManager
    }

    @Bean
    fun passwordEncoder(): BCryptPasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Bean
    fun loginFilter(): UsernamePasswordAuthenticationFilter {
        val authenticationFilter = CustomUserNameAuthenticationFilter(objectMapper)
        authenticationFilter.setAuthenticationManager(authenticationManager())
        authenticationFilter.setFilterProcessesUrl("/login")
        authenticationFilter.setAuthenticationSuccessHandler(CustomSuccessHandler())
        authenticationFilter.setAuthenticationFailureHandler(CustomFailureHandler())

        return authenticationFilter
    }

    @Bean
    fun authenticationFilter(): CustomBasicAuthenticationFilter {
        return CustomBasicAuthenticationFilter(authenticationManager = authenticationManager(), objectMapper = objectMapper)
    }

    fun corsConfig(): CorsConfigurationSource {
        val config = CorsConfiguration()
        config.allowCredentials = true
        config.addAllowedOriginPattern("*")
        config.addAllowedMethod("*")
        config.addAllowedHeader("*")
        config.addExposedHeader("Authorization")
        val source = UrlBasedCorsConfigurationSource()
        source.registerCorsConfiguration("/**", config)
        return source
    }

    class CustomSuccessHandler : AuthenticationSuccessHandler {

        private val log = KotlinLogging.logger {  }

        override fun onAuthenticationSuccess(request: HttpServletRequest?, response: HttpServletResponse?, authentication: Authentication?) {
            log.info { "로그인 성공!!!" }
        }
    }

    class CustomFailureHandler : AuthenticationFailureHandler {

        private val log = KotlinLogging.logger {  }

        override fun onAuthenticationFailure(request: HttpServletRequest?, response: HttpServletResponse, exception: AuthenticationException?) {
            log.info { "로그인 실패!!!" }

            response.sendError(HttpServletResponse.SC_FORBIDDEN, " 인증 실패")
        }
    }

    class CustomAuthenticationEntryPoint(
        private val objectMapper: ObjectMapper
    ) : AuthenticationEntryPoint {

        private val log = KotlinLogging.logger {  }

        override fun commence(request: HttpServletRequest?, response: HttpServletResponse, authException: AuthenticationException?) {
            log.info { "catch authentication entry point!!!" }

            response.sendError(HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED.reasonPhrase)
//            response.sendError(HttpStatus.UNAUTHORIZED.value())

//            val cmResDto = CmResDto(HttpStatus.UNAUTHORIZED, "access denied", authException)
//            responseData(response, objectMapper.writeValueAsString(cmResDto))
        }

    }

    class CustomAccessDeniedHandler : AccessDeniedHandler {

        private val log = KotlinLogging.logger {  }

        override fun handle(request: HttpServletRequest?, response: HttpServletResponse, accessDeniedException: AccessDeniedException?) {
            log.info { "access Denied!!!" }

            response.sendError(HttpServletResponse.SC_FORBIDDEN)
        }

    }

    class CustomLogoutSuccessHandler(
        private val objectMapper: ObjectMapper
    ) : LogoutSuccessHandler {

        private val log = KotlinLogging.logger {  }

        override fun onLogoutSuccess(request: HttpServletRequest?, response: HttpServletResponse, authentication: Authentication?) {
            log.info { "logout success" }

            val context = SecurityContextHolder.getContext()
            context.authentication = null
            SecurityContextHolder.clearContext()

            val cmResDto = CmResDto(HttpStatus.OK, "logout success", null)

            responseData(response, objectMapper.writeValueAsString(cmResDto))
        }
    }


}