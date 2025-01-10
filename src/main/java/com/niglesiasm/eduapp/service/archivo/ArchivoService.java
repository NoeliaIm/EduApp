package com.niglesiasm.eduapp.service.archivo;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ArchivoService {

    void guardarDatosArchivo(MultipartFile file, String subjectId);

    List<ArchivoDTO> getArchivosAll();

    void deleteById(Integer id);
}
