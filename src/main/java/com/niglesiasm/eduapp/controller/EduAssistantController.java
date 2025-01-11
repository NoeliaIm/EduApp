package com.niglesiasm.eduapp.controller;

import com.niglesiasm.eduapp.service.assistant.EduAssistantService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
public class EduAssistantController {

    private final EduAssistantService eduAssistantService;

    public EduAssistantController(EduAssistantService eduAssistantService) {
        this.eduAssistantService = eduAssistantService;
    }

    // Endpoint que llama a la API externa para hacer una consulta desde el chat
    @PostMapping("/api/edu-assistant/chat")
    public String getChatData(@RequestParam("input") String input, @RequestParam(value = "file", required = false) MultipartFile file) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        JwtAuthenticationToken token = (JwtAuthenticationToken) authentication;
        Map<String, Object> claims = token.getToken().getClaims();
        Integer idPersona = (Integer) claims.get("id_persona");
        return eduAssistantService.getRespuestaIa(file, input, idPersona);
    }

    // Endpoint que llama a la API externa para subir un archivo a la base de datos de embeddings
    @PostMapping("/api/edu-assistant/upload")
    @PreAuthorize("authentication.principal.claims['roles'].contains('ADMIN') || authentication.principal.claims['roles'].contains('PROF')")
    public String uploadFile(@RequestParam("file") MultipartFile formData, @RequestParam("subjectId") String subjectId) {
        return eduAssistantService.uploadFile(formData, subjectId);
    }
}
