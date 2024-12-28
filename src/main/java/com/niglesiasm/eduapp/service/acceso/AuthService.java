package com.niglesiasm.eduapp.service.acceso;

public interface AuthService {

    boolean solicitarAcceso(String email) throws Exception;

    String validarAcceso(String email, String token);


}
