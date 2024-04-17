package com.kuskakuy.demo.service.impl.gestion;

import com.kuskakuy.demo.dto.gestion.ServicioDTO;
import com.kuskakuy.demo.model.gestion.ServicioEntity;
import com.kuskakuy.demo.repository.gestion.ServicioRepository;
import com.kuskakuy.demo.service.gestion.ServicioService;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioServiceImpl implements ServicioService {

    @Autowired
    private ServicioRepository repositorio;

    @Autowired
    private ModelMapper mapper;
    
    @Override
    public List<ServicioDTO> findAll() {
         List<ServicioEntity> lista = repositorio.findAll();
        return lista.stream().
                map(p -> mapper.map(p, ServicioDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ServicioDTO> findAllCustom() {
        List<ServicioEntity> lista = repositorio.findAllCustom();
        return lista.stream().
                map(c -> mapper.map(c, ServicioDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ServicioDTO findById(Long id) {
        ServicioEntity servicio = repositorio.findById(id).get();
        return mapper.map(servicio, ServicioDTO.class);
    }

    @Override
    public ServicioDTO add(ServicioDTO entidad) {
        ServicioEntity servicio = mapper.map(entidad, ServicioEntity.class);
        return mapper.map(repositorio.save(servicio), ServicioDTO.class);
    }

    @Override
    public ServicioDTO update(ServicioDTO entidad, Long id) {
        ServicioEntity servicio = repositorio.findById(id).get();
        mapper.map(entidad, servicio);
        servicio.setCodigo(id);
        return mapper.map(repositorio.save(servicio), ServicioDTO.class);
    }

    @Override
    public ServicioDTO delete(Long id) {
        ServicioEntity servicio = repositorio.findById(id).get();
        servicio.setEstado(false);
        return mapper.map(repositorio.save(servicio), ServicioDTO.class);
    }

    @Override
    public ServicioDTO enable(Long id) {
        ServicioEntity servicio = repositorio.findById(id).get();
        servicio.setEstado(true);
        return mapper.map(repositorio.save(servicio), ServicioDTO.class);
    }

}
