package com.kuskakuy.demo.service.impl.gestion;

import com.kuskakuy.demo.dto.gestion.PacienteDTO;
import com.kuskakuy.demo.model.gestion.PacienteEntity;
import com.kuskakuy.demo.repository.gestion.PacienteRepository;
import com.kuskakuy.demo.service.gestion.PacienteService;
import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteServiceImpl implements PacienteService {

    @Autowired
    private PacienteRepository repositorio;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<PacienteDTO> findAll() {
        List<PacienteEntity> lista = repositorio.findAll();
        return lista.stream().
                map(p -> mapper.map(p, PacienteDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<PacienteDTO> findAllCustom() {
        List<PacienteEntity> lista = repositorio.findAllCustom();
        return lista.stream().
                map(c -> mapper.map(c, PacienteDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PacienteDTO findById(Long id) {
        PacienteEntity paciente = repositorio.findById(id).get();
        return mapper.map(paciente, PacienteDTO.class);
    }
 
    @Override
    public PacienteDTO add(PacienteDTO entidad) {
        PacienteEntity paciente = mapper.map(entidad, PacienteEntity.class);
        paciente.setFecha_registro(new Date(System.currentTimeMillis()));
        paciente.setEstado(true);
        return mapper.map(repositorio.save(paciente), PacienteDTO.class);
    }

    @Override
    public PacienteDTO update(PacienteDTO entidad, Long id) {
        PacienteEntity paciente = repositorio.findById(id).get();
        Date registro = paciente.getFecha_registro();
        mapper.map(entidad, paciente);
        paciente.setFecha_registro(registro);
        paciente.setCodigo(id);
        return mapper.map(repositorio.save(paciente), PacienteDTO.class);
    }

    @Override
    public PacienteDTO delete(Long id) {
        PacienteEntity paciente = repositorio.findById(id).get();
        paciente.setEstado(false);
        return mapper.map(repositorio.save(paciente), PacienteDTO.class);
    }

    @Override
    public PacienteDTO enable(Long id) {
        PacienteEntity paciente = repositorio.findById(id).get();
        paciente.setEstado(true);
        return mapper.map(repositorio.save(paciente), PacienteDTO.class);
    }

}
