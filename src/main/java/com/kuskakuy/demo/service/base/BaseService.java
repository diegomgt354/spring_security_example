package com.kuskakuy.demo.service.base;

import java.util.List;

public interface BaseService <T>{
    List<T> findAll();
    List <T>findAllCustom();
    T findById (Long id);
    T add(T entidad );    
    T update (T entidad, Long id);
    T delete (Long id);
    T enable(Long id);
}
