/**
1. Enable CORS
2. Keep CSRF disabled
3. Requires Authentication by default.
4. Secure endpoints with role-based acces.
5. Support Stateless session handling (JWT)
**/


package com.rest_microservice.rest_microservice.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            // 1. Disable CSRF for APIs
            .csrf(AbstractHttpConfigurer::disable)

            // 2. Enable CORS support (relies on your CorsFilter bean)
            .cors(Customizer.withDefaults())

            // 3. Make the API stateless
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

            // 4. Authorization rules
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/public/**").permitAll()       // Public endpoints
                .requestMatchers("/api/admin/**").hasRole("ADMIN")   // Admin-only
                .requestMatchers("/api/user/**").hasAnyRole("USER", "ADMIN") // User + Admin
                .anyRequest().authenticated()                        // All others require auth
            );

        return http.build();
    }
}
