package com.niglesiasm.eduapp.service.archivo;

import com.niglesiasm.eduapp.model.Archivo;

import java.util.List;

public interface ArchivoMapper {
    List<ArchivoDTO> archivosToArchivosDTO(List<Archivo> archivos);

    ArchivoDTO archivoToArchivoDTO(Archivo archivo);
}
