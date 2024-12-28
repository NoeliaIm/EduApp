package com.niglesiasm.eduapp.service.email;

public interface EmailService {

    void enviarTokenAcceso(String email, String token) throws Exception;

    void enviarEmail(String to, String subject, String content);
}
