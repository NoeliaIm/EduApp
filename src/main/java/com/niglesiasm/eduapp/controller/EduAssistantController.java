package com.niglesiasm.eduapp.controller;

import com.niglesiasm.eduapp.service.assistant.EduAssistantService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EduAssistantController {

    private final EduAssistantService eduAssistantService;

    public EduAssistantController(EduAssistantService eduAssistantService) {
        this.eduAssistantService = eduAssistantService;
    }

    // Endpoint de tu API que llama a la API externa
    @PostMapping("/api/edu-assistant/example")
    public String getExampleData(@RequestBody String input) {
        return eduAssistantService.getExample(input);
    }
}
