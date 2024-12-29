package com.niglesiasm.eduapp.service.email.impl;

import com.niglesiasm.eduapp.service.email.EmailService;
import com.niglesiasm.eduapp.service.email.EmailTemplateService;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class EmailServiceImpl implements EmailService {


    private final JavaMailSender mailSender;
    private final EmailTemplateService emailTemplateService;

    @Value("${spring.mail.username}")
    private String fromEmail;
    @Value("${app.base-url}")
    private String baseUrl;


    @Autowired
    public EmailServiceImpl(JavaMailSender mailSender, EmailTemplateService emailTemplateService) {
        this.mailSender = mailSender;
        this.emailTemplateService = emailTemplateService;
    }

    @Override
    public void enviarTokenAcceso(String email, String token) {
        try {

            String contenidoHtml = emailTemplateService.generateEmailContent(token, baseUrl, email);

            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

            helper.setFrom(fromEmail);
            helper.setTo(email);
            helper.setSubject("Tu Token de Acceso");
            helper.setText(contenidoHtml, true);

            mailSender.send(mimeMessage);
            log.info("Email de acceso enviado a: {}", maskEmail(email));
        } catch (Exception e) {
            throw new RuntimeException("Error al enviar el email", e);
        }
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
