package com.niglesiasm.eduapp.repository.annioacademico;

import com.niglesiasm.eduapp.model.AnnioAcademico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnioAcademicoDao extends JpaRepository<AnnioAcademico, Long> {

}
