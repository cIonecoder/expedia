package org.clonecoder.auth.common.security

import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Bean
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer
import org.springframework.security.web.SecurityFilterChain


@EnableWebSecurity
class SecurityConfig {

    private val log = LoggerFactory.getLogger(this::class.java)

    @Bean
    fun webSecurityCustomizer(): WebSecurityCustomizer {
        return WebSecurityCustomizer { web: WebSecurity ->
            web.debug(false)
                .ignoring()
                .antMatchers("/css/**", "/js/**", "/img/**", "/lib/**", "/favicon.ico")
        }
    }

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http.cors().and().authorizeRequests()
            .antMatchers(HttpMethod.DELETE).hasRole(SecurityRole.ADMIN.name)
            .antMatchers(HttpMethod.PUT).hasRole(SecurityRole.ADMIN.name)
            .antMatchers(HttpMethod.PATCH).hasRole(SecurityRole.ADMIN.name)
            .antMatchers(HttpMethod.POST,"/users").permitAll()
            .anyRequest().authenticated()

//        http.exceptionHandling()
//            .accessDeniedHandler { request, response, accessDeniedException ->
//                log.info("Denied to access $request.requestURI, response: $response")
//            }

        return http.build()
    }
}