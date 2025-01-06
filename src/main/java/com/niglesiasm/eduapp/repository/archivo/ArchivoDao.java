package com.niglesiasm.eduapp.repository.archivo;

import com.niglesiasm.eduapp.model.Archivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface ArchivoDao extends JpaRepository<Archivo, Integer> {
}
