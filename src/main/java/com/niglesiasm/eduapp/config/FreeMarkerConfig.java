package com.niglesiasm.eduapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

@Configuration
public class FreeMarkerConfig {

    @Bean
    public FreeMarkerViewResolver freemarkerViewResolver() {
        FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
        resolver.setCache(true);
        resolver.setPrefix("");
        resolver.setSuffix(".html");
        resolver.setContentType("text/html; charset=UTF-8");
        return resolver;
    }

    @Bean
    public FreeMarkerConfigurer freemarkerConfig() {
        FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
        freeMarkerConfigurer.setTemplateLoaderPath("classpath:/templates");
        freeMarkerConfigurer.setDefaultEncoding("UTF-8");

        java.util.Properties properties = new java.util.Properties();
        properties.setProperty("template_update_delay", "0");
        properties.setProperty("locale", "es_ES");
        properties.setProperty("datetime_format", "dd/MM/yyyy HH:mm");
        properties.setProperty("number_format", "#,##0.##");

        freeMarkerConfigurer.setFreemarkerSettings(properties);

        return freeMarkerConfigurer;
    }
}
