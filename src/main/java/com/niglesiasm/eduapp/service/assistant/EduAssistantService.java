package com.niglesiasm.eduapp.service.assistant;

import org.springframework.web.multipart.MultipartFile;

public interface EduAssistantService {

    String getExample(MultipartFile file, String input);

    String uploadFile(MultipartFile file, String subjectId);
}
