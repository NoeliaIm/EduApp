package com.niglesiasm.eduapp.service.acceso.impl;

import com.niglesiasm.eduapp.service.acceso.TokenService;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.SignatureException;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.Key;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;
import java.util.Date;

@Service
@Log4j2
public class TokenServiceImpl implements TokenService {


    private static final long EXPIRATION_TIME = 15 * 60 * 1000; // 15 minutos
    private final PrivateKey privateKey;
    private final String privateKeyPath = System.getenv("PRIVATE_KEY_PATH");

    public TokenServiceImpl() {
        this.privateKey = this.loadPrivateKey();
    }

    private PrivateKey loadPrivateKey() {
        try {
            // Leer la clave privada desde un archivo (private-key.pem)
            String privateKeyContent = new String(Files.readAllBytes(Paths.get(this.privateKeyPath)));
            privateKeyContent = privateKeyContent
                    .replace("-----BEGIN PRIVATE KEY-----", "")
                    .replace("-----END PRIVATE KEY-----", "")
                    .replaceAll("\\s+", "");
            byte[] keyBytes = Base64.getDecoder().decode(privateKeyContent);
            PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            return keyFactory.generatePrivate(spec);
        } catch (Exception e) {
            throw new RuntimeException("Error al cargar la clave privada", e);
        }
    }

    @Override
    public String generarTokenSession(String email) {
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(privateKey, SignatureAlgorithm.RS256)
                .compact();
    }

    @Override
    public boolean validarToken(String token) {
        try {
            // Parsear el token
            Jws<Claims> claims = Jwts.parserBuilder()
                    .setSigningKey(privateKey)
                    .build()
                    .parseClaimsJws(token);

            // Obtener información del token
            Date fechaCreacion = claims.getBody().getIssuedAt();
            Date fechaExpiracion = claims.getBody().getExpiration();
            String subject = claims.getBody().getSubject();

            // Verificaciones adicionales
            if (fechaCreacion == null || fechaExpiracion == null) {
                log.warn("Token inválido: Falta fecha de creación o expiración");
                return false;
            }

            // Verificar expiración
            boolean tokenValido = !fechaExpiracion.before(new Date());

            if (!tokenValido) {
                log.info("Token expirado - Creado: {}, Expira: {}", fechaCreacion, fechaExpiracion);
            } else {
                log.debug("Token válido para: {}", subject);
            }

            return tokenValido;

        } catch (ExpiredJwtException e) {
            log.warn("Token expirado: {}", e.getMessage());
            return false;
        } catch (SignatureException e) {
            log.error("Firma de token inválida: {}", e.getMessage());
            return false;
        } catch (MalformedJwtException e) {
            log.error("Token con formato inválido: {}", e.getMessage());
            return false;
        } catch (JwtException e) {
            log.error("Error al validar token: {}", e.getMessage());
            return false;
        }
    }

    @Override
    public String extraerEmail(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(privateKey)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    @Override
    public Key getSecretKey() {
        return this.privateKey;
    }
}