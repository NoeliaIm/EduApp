package com.niglesiasm.eduapp.repository.curso;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.niglesiasm.eduapp.model.Curso;

@Repository
public interface CursoDao extends JpaRepository<Curso, Long> {
    
}
