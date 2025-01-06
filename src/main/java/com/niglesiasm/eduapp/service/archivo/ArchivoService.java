package com.niglesiasm.eduapp.service.archivo;

import org.springframework.web.multipart.MultipartFile;

public interface ArchivoService {

    void guardarDatosArchivo(MultipartFile file, String subjectId);
}
