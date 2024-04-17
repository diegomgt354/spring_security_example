package com.kuskakuy.demo.repository.proceso;

import com.kuskakuy.demo.model.proceso.RegistroCitaEntity;
import com.kuskakuy.demo.repository.base.BaseRepository;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

public interface RegistroCitaRepository extends BaseRepository<RegistroCitaEntity, Long> {

    @Query("select rc from RegistroCitaEntity rc where rc.estado=true")
    List<RegistroCitaEntity> findAllCustom();
    
    List<RegistroCitaEntity> findByCodigoNot(Long id);
}
