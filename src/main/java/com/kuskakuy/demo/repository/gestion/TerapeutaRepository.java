package com.kuskakuy.demo.repository.gestion;

import com.kuskakuy.demo.model.gestion.TerapeutaEntity;
import com.kuskakuy.demo.repository.base.BaseRepository;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

public interface TerapeutaRepository extends BaseRepository<TerapeutaEntity, Long> {
    
    @Query("select t from TerapeutaEntity t where t.estado = true")
    List<TerapeutaEntity> findAllCustom();
    
}
