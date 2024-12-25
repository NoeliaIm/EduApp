package com.niglesiasm.eduapp.repository.necesidadespecial;

import com.niglesiasm.eduapp.model.NecesidadEspecial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NecesidadEspecialDao extends JpaRepository<NecesidadEspecial, Integer> {
}
