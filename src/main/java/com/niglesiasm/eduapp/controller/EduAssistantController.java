package com.niglesiasm.eduapp.controller;

import com.niglesiasm.eduapp.service.assistant.EduAssistantService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class EduAssistantController {

    private final EduAssistantService eduAssistantService;

    public EduAssistantController(EduAssistantService eduAssistantService) {
        this.eduAssistantService = eduAssistantService;
    }

    // Endpoint que llama a la API externa para hacer una consulta desde el chat
    @PostMapping("/api/edu-assistant/example")
    public String getExampleData(@RequestParam("input") String input, @RequestParam(value = "file", required = false) MultipartFile file) {
        return eduAssistantService.getExample(file, input);
    }

    // Endpoint que llama a la API externa para subir un archivo a la base de datos de embeddings
    @PostMapping("/api/edu-assistant/upload")
    public String uploadFile(@RequestParam("file") MultipartFile formData, @RequestParam("subjectId") String subjectId) {
        return eduAssistantService.uploadFile(formData, subjectId);
    }
}
