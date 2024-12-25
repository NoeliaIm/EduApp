package com.niglesiasm.eduapp.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "app.pais")
public class PaisProperties {
    private Integer defaultPais;

    public Integer getDefaultPais() {
        return defaultPais;
    }

    public void setDefaultPais(Integer defaultPais) {
        this.defaultPais = defaultPais;
    }
}
