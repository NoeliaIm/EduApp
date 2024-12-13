package com.niglesiasm.eduapp.service.email.impl;

import com.niglesiasm.eduapp.service.email.EmailService;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class EmailServiceImpl implements EmailService {


    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String fromEmail;


    @Autowired
    public EmailServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void enviarTokenAcceso(String email, String token) {
        SimpleMailMessage mensaje = new SimpleMailMessage();
        mensaje.setTo(email);
        mensaje.setSubject("Tu Token de Acceso");
        mensaje.setText("Tu token de acceso es: " + token +
                "\nCaducará en 15 minutos.");

        this.enviarEmail(email, mensaje.getSubject(), mensaje.getText());
    }


    @Override
    public void enviarEmail(String to, String subject, String content) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            helper.setFrom(fromEmail);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);

            mailSender.send(message);

            log.info("Email enviado a: {}", maskEmail(to));
        } catch (Exception e) {
            log.error("Error enviando email", e);
            throw new RuntimeException("Error en envío de email", e);
        }
    }

    private String maskEmail(String email) {
        return email.replaceAll("(?<=.{3}).(?=[^@]*@)", "*");
    }
}
