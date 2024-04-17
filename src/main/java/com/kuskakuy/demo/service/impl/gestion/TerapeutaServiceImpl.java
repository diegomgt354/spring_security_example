package com.kuskakuy.demo.service.impl.gestion;

import com.kuskakuy.demo.dto.gestion.TerapeutaDTO;
import com.kuskakuy.demo.model.gestion.TerapeutaEntity;
import com.kuskakuy.demo.repository.gestion.TerapeutaRepository;
import com.kuskakuy.demo.service.gestion.TerapeutaService;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TerapeutaServiceImpl implements TerapeutaService {

    @Autowired
    private TerapeutaRepository repositorio;

    @Autowired
    private ModelMapper mapper;
    
    @Override
    public List<TerapeutaDTO> findAll() {
         List<TerapeutaEntity> lista = repositorio.findAll();
        return lista.stream().
                map(p -> mapper.map(p, TerapeutaDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<TerapeutaDTO> findAllCustom() {
        List<TerapeutaEntity> lista = repositorio.findAllCustom();
        return lista.stream().
                map(c -> mapper.map(c, TerapeutaDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public TerapeutaDTO findById(Long id) {
        TerapeutaEntity terapeuta = repositorio.findById(id).get();
        return mapper.map(terapeuta, TerapeutaDTO.class);
    }

    @Override
    public TerapeutaDTO add(TerapeutaDTO entidad) {
        TerapeutaEntity terapeuta = mapper.map(entidad, TerapeutaEntity.class);
        return mapper.map(repositorio.save(terapeuta), TerapeutaDTO.class);
    }

    @Override
    public TerapeutaDTO update(TerapeutaDTO entidad, Long id) {
        TerapeutaEntity terapeuta = repositorio.findById(id).get();
        mapper.map(entidad, terapeuta);
        terapeuta.setCodigo(id);
        return mapper.map(repositorio.save(terapeuta), TerapeutaDTO.class);
    }

    @Override
    public TerapeutaDTO delete(Long id) {
        TerapeutaEntity terapeuta = repositorio.findById(id).get();
        terapeuta.setEstado(false);
        return mapper.map(repositorio.save(terapeuta), TerapeutaDTO.class);
    }

    @Override
    public TerapeutaDTO enable(Long id) {
        TerapeutaEntity terapeuta = repositorio.findById(id).get();
        terapeuta.setEstado(true);
        return mapper.map(repositorio.save(terapeuta), TerapeutaDTO.class);
    }

}
