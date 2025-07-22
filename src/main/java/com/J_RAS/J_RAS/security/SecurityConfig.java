package com.J_RAS.J_RAS.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable()) // Deshabilita CSRF para APIs REST
                .authorizeHttpRequests(auth -> auth
                                .requestMatchers("/api/auth/login",
                                        "/api/productos",
                                        "/api/categorias/**",
                                        "/api/productos/**",
                                        "/api/usuarios**").permitAll() // URLs públicas
//                              .requestMatchers("/api/usuarios").hasRole("ADMIN")
                                .anyRequest().authenticated() // Las demás requieren autenticación
                )
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // No mantiene sesión
                // .formLogin(Customizer.withDefaults()) // Aquí comentar o eliminar para evitar formulario por defecto
                .build();
    }
}
