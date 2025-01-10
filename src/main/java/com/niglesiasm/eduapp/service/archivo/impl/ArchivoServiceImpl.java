package com.niglesiasm.eduapp.service.archivo.impl;

import com.niglesiasm.eduapp.model.Archivo;
import com.niglesiasm.eduapp.model.Asignatura;
import com.niglesiasm.eduapp.repository.archivo.ArchivoDao;
import com.niglesiasm.eduapp.repository.asignatura.AsignaturaDao;
import com.niglesiasm.eduapp.service.archivo.ArchivoDTO;
import com.niglesiasm.eduapp.service.archivo.ArchivoMapper;
import com.niglesiasm.eduapp.service.archivo.ArchivoService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.Instant;
import java.util.List;

@Service
public class ArchivoServiceImpl implements ArchivoService {


    private final AsignaturaDao asignaturaDao;
    private final ArchivoDao archivoDao;
    private final ArchivoMapper archivoMapper;


    public ArchivoServiceImpl(AsignaturaDao asignaturaDao, ArchivoDao archivoDao, ArchivoMapper archivoMapper) {
        this.asignaturaDao = asignaturaDao;
        this.archivoDao = archivoDao;
        this.archivoMapper = archivoMapper;
    }

    @Override
    @Transactional
    public void guardarDatosArchivo(MultipartFile file, String subjectId) {
        Archivo archivo = this.createArchivo(file, subjectId);
        this.archivoDao.save(archivo);
    }


    private Archivo createArchivo(MultipartFile file, String subjectId) {
        Asignatura asignatura = asignaturaDao.findByIdAsignatura(Integer.parseInt(subjectId));

        Archivo archivo = new Archivo();
        archivo.setFileName(file.getOriginalFilename()); // file.getName() no da el nombre real del archivo
        archivo.setAsignatura(asignatura);
        archivo.setFileSize(file.getSize());


        return archivo;
    }

    @Override
    public List<ArchivoDTO> getArchivosAll() {
        List<Archivo> archivos = this.archivoDao.findAll();
        if (!archivos.isEmpty()) {
            archivos = archivos.stream().filter(archivo -> archivo.getDeletedDate() == null).toList();
            return this.archivoMapper.archivosToArchivosDTO(archivos);
        }
        return List.of();
    }

    @Override
    public void deleteById(Integer id) {

        Archivo archivo = this.archivoDao.findById(id).orElseThrow(() -> new IllegalArgumentException("No se encontró el archivo con id " + id));
        archivo.setDeletedDate(Instant.now());
        this.archivoDao.save(archivo);
    }
}
