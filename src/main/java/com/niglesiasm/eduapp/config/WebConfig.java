package com.niglesiasm.eduapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Permitir todos los endpoints
                .allowedOrigins("http://localhost:5173") // Permitir llamadas desde el frontend
                .allowedMethods("*") // Permitir todos los métodos HTTP
                .allowedHeaders("*")
                .exposedHeaders("Authorization")// Permitir todos los encabezados
                .allowCredentials(true); // Permitir credenciales (si es necesario)
    }
}