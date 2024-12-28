package com.niglesiasm.eduapp.service.email.impl;

import com.niglesiasm.eduapp.service.email.EmailTemplateService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

@Component
public class EmailTemplateServiceImpl implements EmailTemplateService {

    private final Configuration configuration;

    @Autowired
    public EmailTemplateServiceImpl(FreeMarkerConfigurer freeMarkerConfigurer) {
        this.configuration = freeMarkerConfigurer.getConfiguration();
    }

    public String generateEmailContent(String token, String baseUrl) throws Exception {
        Template template = configuration.getTemplate("email-template.html");

        Map<String, Object> model = new HashMap<>();
        model.put("token", token);
        model.put("baseUrl", baseUrl);

        StringWriter writer = new StringWriter();
        template.process(model, writer);

        return writer.toString();
    }

}
