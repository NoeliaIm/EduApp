package com.niglesiasm.eduapp.repository.curso;

import com.niglesiasm.eduapp.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoDao extends JpaRepository<Curso, Integer> {

}
