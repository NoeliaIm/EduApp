package com.niglesiasm.eduapp.service.assistant.impl;

import com.niglesiasm.eduapp.service.assistant.EduAssistantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EduAssistantServiceImpl implements EduAssistantService {

    private RestTemplate restTemplate;
    private static final String BASE_URL = "http://127.0.0.1:8000/";

    @Autowired
    public EduAssistantServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public String getExample(String input) {

        // Crear la solicitud HTTP
        HttpEntity<String> request = new HttpEntity<>(null);

        String encodedInput = java.net.URLEncoder.encode(input, java.nio.charset.StandardCharsets.UTF_8);

        StringBuilder urlFlow = new StringBuilder();
        urlFlow.append(BASE_URL + "run_langflow_historia?input_message=");
        urlFlow.append(encodedInput);

        // Realizar la llamada POST
        ResponseEntity<String> response = restTemplate.postForEntity(urlFlow.toString(), request, String.class);


        // Retornar la respuesta
        return response.getBody();
    }
}
