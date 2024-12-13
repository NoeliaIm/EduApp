package com.niglesiasm.eduapp.acceso;

import com.niglesiasm.eduapp.service.acceso.TokenService;
import io.jsonwebtoken.Jwts;


import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.jwt.BadJwtException;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@Log4j2
public class SecurityConfig {

    @Autowired
    private TokenService tokenService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/auth/**").permitAll()
                        .anyRequest().authenticated()
                )
                .oauth2ResourceServer(oauth2 -> oauth2
                        .jwt(jwt -> jwt
                                .decoder(jwtDecoder())
                        )
                );

        return http.build();
    }

    @Bean
    public JwtDecoder jwtDecoder() {
        return token -> {
            try {

                // Logging de token
                log.info("Token recibido: {}" ,token);

                var claims = Jwts.parserBuilder()
                        .setSigningKey(tokenService.getSecretKey())
                        .build()
                        .parseClaimsJws(token)
                        .getBody();

                // Logging de claims
                log.info("Claims: {}" ,claims);

                return Jwt.withTokenValue(token)
                        .headers(h -> {
                            h.put("alg", "RS256");
                            h.put("typ", "JWT");
                        })
                        .subject(claims.getSubject())
                        .issuedAt(claims.getIssuedAt().toInstant())
                        .expiresAt(claims.getExpiration().toInstant())
                        .claim("id_persona", claims.get("id_persona"))
                        .claim("nombre", claims.get("nombre"))
                        .claim("apellido", claims.get("apellido"))
                        .claim("roles", claims.get("roles")) // Incluir roles
                        .build();
            } catch (Exception e) {
                // Logging de errores
                log.error("Error en decodificación de token: {}" ,e.getMessage());
                throw new BadJwtException("Token inválido");
            }
        };
    }
}