package com.ajay.springgame;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers(
                                        "/v3/api-docs/**",    // Allow access to OpenAPI docs
                                        "/swagger-ui/**",     // Allow access to Swagger UI
                                        "/swagger-ui.html",
                                        "/api/v1/users"
                                ).permitAll()
                                .anyRequest().authenticated() // Secure other endpoints
                )
                .csrf(csrf -> csrf.disable());  // Disable CSRF for APIs
        return http.build();
    }
}
