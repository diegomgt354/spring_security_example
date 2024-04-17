package com.kuskakuy.demo.repository.seguridad;

import com.kuskakuy.demo.model.seguridad.UserEntity;
import com.kuskakuy.demo.repository.base.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<UserEntity, Long> {

    UserEntity findByUserName(String user);
}
