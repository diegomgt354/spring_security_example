package com.kuskakuy.demo.service.impl.proceso;

import com.kuskakuy.demo.dto.proceso.RegistroCitaDTO;
import com.kuskakuy.demo.model.proceso.RegistroCitaEntity;
import com.kuskakuy.demo.repository.proceso.RegistroCitaRepository;
import com.kuskakuy.demo.service.proceso.RegistroCitaService;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistroCitaServiceImpl implements RegistroCitaService {
	
	
	private static final Logger log = LoggerFactory.getLogger(RegistroCitaServiceImpl.class);

	
    @Autowired
    private RegistroCitaRepository repositorio;

    @Autowired
    private ModelMapper mapper;
    
    @Override
    public List<RegistroCitaDTO> findAll() {
         List<RegistroCitaEntity> lista = repositorio.findAll();
        return lista.stream().
                map(p -> mapper.map(p, RegistroCitaDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<RegistroCitaDTO> findAllCustom() {
        List<RegistroCitaEntity> lista = repositorio.findAllCustom();
        return lista.stream().
                map(c -> mapper.map(c, RegistroCitaDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public RegistroCitaDTO findById(Long id) {
        RegistroCitaEntity registroCita = repositorio.findById(id).get();
        return mapper.map(registroCita, RegistroCitaDTO.class);
    }

    @Override
    public RegistroCitaDTO add(RegistroCitaDTO entidad) {
    	List<RegistroCitaEntity> citasExistentes = repositorio.findAll();
    	List<RegistroCitaDTO> dtos = citasExistentes.stream().map(
    			c->mapper.map(c, RegistroCitaDTO.class)).toList(); 
    	
    	for(RegistroCitaDTO cita : dtos) {
    		if(cita.getTerapeuta().getCodigo().toString().equals(entidad.getTerapeuta().getCodigo().toString()) && 
    				cita.getFecha_cita().toString().equals(entidad.getFecha_cita().toString()) &&
    				cita.getHora_inicio_cita()==entidad.getHora_inicio_cita() && cita.getEstado()) {
    			return null;
    		}
    	} 
    	       
        // agregamos el registro de cita
        RegistroCitaEntity registroCita = mapper.map(entidad, RegistroCitaEntity.class);
        return mapper.map(repositorio.save(registroCita), RegistroCitaDTO.class);
    }

    @Override
    public RegistroCitaDTO update(RegistroCitaDTO entidad, Long id) {
        
    	List<RegistroCitaEntity> citasExistentesMenosUpdate = repositorio.findByCodigoNot(id);
    	
//    	for(RegistroCitaEntity ee : citasExistentesMenosUpdate) {
//    		log.info(String.valueOf(ee.getCodigo()));
//    	}
    	
    	List<RegistroCitaDTO> dtos = citasExistentesMenosUpdate.stream().map(
    			c->mapper.map(c, RegistroCitaDTO.class)).toList(); 
    	
    	for(RegistroCitaDTO cita : dtos) {
    		if(cita.getTerapeuta().getCodigo().toString().equals(entidad.getTerapeuta().getCodigo().toString()) && 
    				cita.getFecha_cita().toString().equals(entidad.getFecha_cita().toString()) &&
    				cita.getHora_inicio_cita()==entidad.getHora_inicio_cita() && cita.getEstado()) {
    			return null;
    		}
    	}
    	
        // guardo la cita           
        RegistroCitaEntity registroCita = mapper.map(entidad, RegistroCitaEntity.class);
        return mapper.map(repositorio.save(registroCita), RegistroCitaDTO.class);
    }

    @Override
    public RegistroCitaDTO delete(Long id) {
        RegistroCitaEntity registroCita = repositorio.findById(id).get();
        registroCita.setEstado(false);
        return mapper.map(repositorio.save(registroCita), RegistroCitaDTO.class);
    }

    @Override
    public RegistroCitaDTO enable(Long id) {
        RegistroCitaEntity registroCita = repositorio.findById(id).get();
        registroCita.setEstado(true);
        return mapper.map(repositorio.save(registroCita), RegistroCitaDTO.class);
    }

    
}