package com.kuskakuy.demo.repository.gestion;

import com.kuskakuy.demo.model.gestion.ServicioEntity;
import com.kuskakuy.demo.repository.base.BaseRepository;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

public interface ServicioRepository extends BaseRepository<ServicioEntity, Long> {
    
    @Query("select s from ServicioEntity s where s.estado = true")
    List<ServicioEntity> findAllCustom();
    
}
