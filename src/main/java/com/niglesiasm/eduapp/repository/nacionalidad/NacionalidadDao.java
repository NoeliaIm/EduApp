package com.niglesiasm.eduapp.repository.nacionalidad;

import com.niglesiasm.eduapp.model.Nacionalidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NacionalidadDao extends JpaRepository<Nacionalidad, Long> {

}
