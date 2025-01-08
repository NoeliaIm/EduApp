package com.niglesiasm.eduapp.service.archivo.impl;

import com.niglesiasm.eduapp.model.Archivo;
import com.niglesiasm.eduapp.service.archivo.ArchivoDTO;
import com.niglesiasm.eduapp.service.archivo.ArchivoMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

@Service
public class ArchivoMapperImpl implements ArchivoMapper {
    @Override
    public List<ArchivoDTO> archivosToArchivosDTO(List<Archivo> archivos) {
        List<ArchivoDTO> archivoDTOS = new ArrayList<>();
        for (Archivo archivo : archivos) {
            archivoDTOS.add(archivoToArchivoDTO(archivo));
        }
        return archivoDTOS;
    }

    @Override
    public ArchivoDTO archivoToArchivoDTO(Archivo archivo) {
        ArchivoDTO archivoDTO = new ArchivoDTO();
        archivoDTO.setIdArchivo(archivo.getId());
        archivoDTO.setNombreArchivo(archivo.getFileName());
        // calculo de bytes a mega bytes en formato String para mostrar así , ej: 1.5 MB
        archivoDTO.setTamanio(String.format("%.2f MB", archivo.getFileSize() * 8 * Math.pow(10, -6)));
        // pasamos de Instant a LocalDate
        archivoDTO.setFechaSubida(LocalDate.ofInstant(archivo.getUploadDate(), ZoneOffset.UTC));
        archivoDTO.setAsignatura(archivo.getAsignatura().getNombreAsignatura());
        return archivoDTO;
    }
}
