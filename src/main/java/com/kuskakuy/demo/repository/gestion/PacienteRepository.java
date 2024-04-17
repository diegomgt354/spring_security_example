package com.kuskakuy.demo.repository.gestion;

import com.kuskakuy.demo.model.gestion.PacienteEntity;
import com.kuskakuy.demo.repository.base.BaseRepository;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

public interface PacienteRepository extends BaseRepository<PacienteEntity, Long>{
    
    @Query("select p from PacienteEntity p where p.estado = true")
    List<PacienteEntity> findAllCustom();
    
}