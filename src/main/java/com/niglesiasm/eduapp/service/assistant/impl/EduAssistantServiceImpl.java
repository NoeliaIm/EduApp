package com.niglesiasm.eduapp.service.assistant.impl;

import com.niglesiasm.eduapp.service.assistant.EduAssistantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

@Service
public class EduAssistantServiceImpl implements EduAssistantService {

    private RestTemplate restTemplate;
    private static final String BASE_URL = "http://127.0.0.1:8000/";

    @Autowired
    public EduAssistantServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public String getExample(MultipartFile file, String input) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("input_message", input);

        if (file != null) {
            body.add("file", file.getResource());
        }

        HttpEntity<MultiValueMap<String, Object>> request =
                new HttpEntity<>(body, headers);

        StringBuilder urlFlow = new StringBuilder();
        urlFlow.append(BASE_URL + "run_langflow_historia");

        ResponseEntity<String> response = restTemplate.postForEntity(
                urlFlow.toString(),
                request,
                String.class
        );
        // Retornar la respuesta
        return response.getBody();
    }


    @Override
    public String uploadFile(MultipartFile file) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("file", file.getResource());

        HttpEntity<MultiValueMap<String, Object>> request =
                new HttpEntity<>(body, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(
                BASE_URL + "upload",
                request,
                String.class
        );
        // Retornar la respuesta
        return response.getBody();
    }
}
