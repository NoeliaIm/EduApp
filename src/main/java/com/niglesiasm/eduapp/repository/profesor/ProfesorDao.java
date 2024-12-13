package com.niglesiasm.eduapp.repository.profesor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.niglesiasm.eduapp.model.Profesor;

@Repository
public interface ProfesorDao extends JpaRepository<Profesor, Long> {
    
}
