package com.niglesiasm.eduapp.repository.nacionalidad;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.niglesiasm.eduapp.model.Nacionalidad;

@Repository
public interface NacionalidadDao extends JpaRepository<Nacionalidad, Long> {
    
}
