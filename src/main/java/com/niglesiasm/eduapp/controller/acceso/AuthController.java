package com.niglesiasm.eduapp.controller.acceso;

import com.niglesiasm.eduapp.acceso.SolicitudAccesoDto;
import com.niglesiasm.eduapp.service.acceso.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/solicitar-acceso")
    public ResponseEntity<String> solicitarAcceso(
            @RequestBody @Valid SolicitudAccesoDto solicitud
    ) {
        boolean resultado = authService.solicitarAcceso(solicitud.getEmail());
        return ResponseEntity.ok("Token enviado al email");
    }

    @PostMapping("/validar-acceso")
    public ResponseEntity<String> validarAcceso(
            @RequestParam String email,
            @RequestParam String token
    ) {
        String jwtAcceso = authService.validarAcceso(email, token);
        return ResponseEntity.ok(jwtAcceso);
    }
}
