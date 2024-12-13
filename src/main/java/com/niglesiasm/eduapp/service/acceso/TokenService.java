package com.niglesiasm.eduapp.service.acceso;

import java.security.Key;

public interface TokenService {

    String generarTokenSession(String mail);

    boolean validarToken(String token);

    String extraerEmail(String token);

    Key getSecretKey();
}
