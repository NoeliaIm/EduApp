package com.niglesiasm.eduapp.service.email;

public interface EmailTemplateService {

    String generateEmailContent(String token, String baseUrl, String email) throws Exception;
}
