package com.niglesiasm.eduapp.service.assistant.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.niglesiasm.eduapp.service.alumno.AlumnoDTO;
import com.niglesiasm.eduapp.service.alumno.AlumnoService;
import com.niglesiasm.eduapp.service.alumnoasignatura.AlumnoAsignaturaService;
import com.niglesiasm.eduapp.service.archivo.ArchivoService;
import com.niglesiasm.eduapp.service.asignatura.AsignaturaDTO;
import com.niglesiasm.eduapp.service.assistant.EduAssistantService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
public class EduAssistantServiceImpl implements EduAssistantService {

    private final RestTemplate restTemplate;
    private final ArchivoService archivoService;
    private final AlumnoService alumnoService;
    private final AlumnoAsignaturaService alumnoAsignaturaService;
    private static final String BASE_URL = "http://127.0.0.1:8000/";

    @Autowired
    public EduAssistantServiceImpl(RestTemplate restTemplate, ArchivoService archivoService, AlumnoService alumnoService, AlumnoAsignaturaService alumnoAsignaturaService) {
        this.restTemplate = restTemplate;
        this.archivoService = archivoService;
        this.alumnoService = alumnoService;
        this.alumnoAsignaturaService = alumnoAsignaturaService;
    }

    @Override
    public String getRespuestaIa(MultipartFile file, String input, Integer idPersona) {

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
        urlFlow.append(BASE_URL + "run_langflow_chat");

        ResponseEntity<String> response = restTemplate.postForEntity(
                urlFlow.toString(),
                request,
                String.class
        );

        if (response.getStatusCode().equals(HttpStatus.OK)) {
            this.procesarPregunta(input, idPersona);
        }
        // Retornar la respuesta
        return response.getBody();
    }


    protected String getClasificacion(String pregunta, List<String> asignaturas) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        String inputMessage = pregunta + "[" + String.join(", ", asignaturas) + "]";
        body.add("input_message", inputMessage);

        HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<>(body, headers);

        StringBuilder urlFlow = new StringBuilder();
        urlFlow.append(BASE_URL + "clasificar_pregunta");


        try {

            ResponseEntity<String> response = restTemplate.postForEntity(
                    urlFlow.toString(),
                    request,
                    String.class
            );
            if (!response.getStatusCode().equals(HttpStatus.OK)) {
                return "";
            }

            ObjectMapper mapper = new ObjectMapper();
            JsonNode responseJson = null;

            responseJson = mapper.readTree(response.getBody());
            return responseJson.get("asignatura").asText();
        } catch (Exception e) {
            return "";
        }
    }

    @Transactional
    protected void procesarPregunta(String pregunta, Integer idPersona) {
        Optional<AlumnoDTO> alumno = this.alumnoService.findByPersonaId(idPersona);
        if (alumno.isPresent()) {
            Integer idAlumno = alumno.get().getId();
            List<String> asignaturas = alumno.get().getAsignaturas().stream().map(AsignaturaDTO::getNombreAsignatura).toList();
            String asignaturaClasificada = this.getClasificacion(pregunta, asignaturas);
            alumno.get().getAsignaturas().stream()
                    .filter(asignatura -> asignatura.getNombreAsignatura().equals(asignaturaClasificada))
                    .findFirst()
                    .map(AsignaturaDTO::getIdAsignatura).ifPresent(idAsignatura -> this.alumnoAsignaturaService.incrementarContadorPregunta(idAlumno, idAsignatura));
        }
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
