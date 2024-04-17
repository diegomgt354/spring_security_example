package com.kuskakuy.demo.repository.seguridad;

import com.kuskakuy.demo.model.seguridad.RoleEntity;
import com.kuskakuy.demo.repository.base.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends BaseRepository<RoleEntity, Long> {
    
}
