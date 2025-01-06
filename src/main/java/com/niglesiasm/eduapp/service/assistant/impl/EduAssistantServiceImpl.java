package com.niglesiasm.eduapp.service.assistant.impl;

import com.niglesiasm.eduapp.service.archivo.ArchivoService;
import com.niglesiasm.eduapp.service.assistant.EduAssistantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

@Service
public class EduAssistantServiceImpl implements EduAssistantService {

    private final RestTemplate restTemplate;
    private final ArchivoService archivoService;
    private static final String BASE_URL = "http://127.0.0.1:8000/";

    @Autowired
    public EduAssistantServiceImpl(RestTemplate restTemplate, ArchivoService archivoService) {
        this.restTemplate = restTemplate;
        this.archivoService = archivoService;

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
    public String uploadFile(MultipartFile file, String subjectId) {
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


        if (subjectId == null || !response.getStatusCode().equals(HttpStatus.OK)) {
            throw new IllegalArgumentException("Invalid input parameters or response");
        }

        this.archivoService.guardarDatosArchivo(file, subjectId);
        // Retornar la respuesta
        return response.getBody();
    }

}
