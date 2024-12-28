package com.niglesiasm.eduapp.service.acceso.impl;

import com.niglesiasm.eduapp.model.Persona;
import com.niglesiasm.eduapp.model.enums.Rol;
import com.niglesiasm.eduapp.repository.persona.PersonaDao;
import com.niglesiasm.eduapp.service.acceso.AuthService;
import com.niglesiasm.eduapp.service.acceso.TokenService;
import com.niglesiasm.eduapp.service.email.EmailService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private PersonaDao personaDao;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private EmailService emailService;

    @Override
    @Transactional
    public boolean solicitarAcceso(String email) throws Exception {
        // Verificar que el email exista en personas
        if (!personaDao.existsByEmail(email)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Email no registrado"
            );
        }

        // Generar token de sesión
        String token = tokenService.generarTokenSession(email);

        // Enviar email con token
        emailService.enviarTokenAcceso(email, token);

        return true;
    }

    @Override
    public String validarAcceso(String email, String token) {
        // Validar token
        if (!tokenService.validarToken(token)) {
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED,
                    "Token inválido o caducado"
            );
        }

        // Verificar que el email del token coincida
        String emailTokenizado = tokenService.extraerEmail(token);
        if (!email.equals(emailTokenizado)) {
            throw new ResponseStatusException(
                    HttpStatus.FORBIDDEN,
                    "Token no corresponde al email"
            );
        }

        // Generar JWT de acceso
        return generarJWTAcceso(email);
    }

    private String generarJWTAcceso(String email) {
        Optional<Persona> persona = personaDao.findByEmail(email);

        List<String> roles = persona.map(p -> p.getRoles().stream().map(Rol::getName).collect(Collectors.toList())).orElse(new ArrayList<>());

        return persona.map(p -> Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setSubject(p.getEmail())
                .claim("id_persona", p.getId())
                .claim("nombre", p.getNombre())
                .claim("apellido", p.getApellido1())
                .claim("roles", roles)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 168 * 60 * 60 * 1000)) // 160 horas, 7 días
                .signWith(tokenService.getSecretKey(), SignatureAlgorithm.RS256)
                .compact()
        ).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Persona no encontrada"
        ));
    }
}