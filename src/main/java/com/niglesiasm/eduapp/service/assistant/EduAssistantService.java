package com.niglesiasm.eduapp.service.assistant;

import org.springframework.web.multipart.MultipartFile;

public interface EduAssistantService {

    String getRespuestaIa(MultipartFile file, String input, Integer idPersona);

    String uploadFile(MultipartFile file, String subjectId);
}
