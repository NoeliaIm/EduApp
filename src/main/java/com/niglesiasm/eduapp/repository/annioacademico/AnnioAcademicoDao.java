package com.niglesiasm.eduapp.repository.annioacademico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.niglesiasm.eduapp.model.AnnioAcademico;

@Repository
public interface AnnioAcademicoDao extends JpaRepository<AnnioAcademico, Long> {
    
}
