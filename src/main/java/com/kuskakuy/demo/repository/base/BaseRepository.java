package com.kuskakuy.demo.repository.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean // no debe considerarse un repositorio en sí mismo, sirve como una interfaz base para otros repositorios.
public interface BaseRepository <T,ID> extends JpaRepository<T, ID> { // entidad T de id  ID   
}
