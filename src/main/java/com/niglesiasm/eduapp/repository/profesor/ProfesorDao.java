package com.niglesiasm.eduapp.repository.profesor;

import com.niglesiasm.eduapp.model.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesorDao extends JpaRepository<Profesor, Long> {

}
