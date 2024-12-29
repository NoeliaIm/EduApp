package com.niglesiasm.eduapp.controller.acceso;

import com.niglesiasm.eduapp.acceso.SolicitudAccesoDto;
import com.niglesiasm.eduapp.acceso.ValidacionAccesoDto;
import com.niglesiasm.eduapp.service.acceso.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/solicitar-acceso")
    public ResponseEntity<Map<String, String>> solicitarAcceso(
            @RequestBody @Valid SolicitudAccesoDto solicitud
    ) throws Exception {
        boolean resultado = authService.solicitarAcceso(solicitud.getEmail());
        Map<String, String> response = new HashMap<>();
        if (!resultado) {
            response.put("message", "Error al enviar el token");
            return ResponseEntity.badRequest().body(response);
        }

        response.put("message", "Token enviado al email");
        return ResponseEntity.ok(response);
    }

    @PostMapping("/validar-acceso")
    public ResponseEntity<Map<String, Object>> validarAcceso(
            @RequestBody @Valid ValidacionAccesoDto validacionDto
    ) {
        String jwtAcceso = authService.validarAcceso(validacionDto.getEmail(), validacionDto.getToken());
        return ResponseEntity.ok(Map.of(
                "success", true,
                "token", jwtAcceso
        ));
    }
}
