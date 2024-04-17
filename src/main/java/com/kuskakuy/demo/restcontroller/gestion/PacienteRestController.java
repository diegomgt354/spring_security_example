package com.kuskakuy.demo.restcontroller.gestion;

import com.kuskakuy.demo.dto.gestion.PacienteDTO;
import com.kuskakuy.demo.service.gestion.PacienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paciente")
public class PacienteRestController {

    @Autowired
    private PacienteService servicio;

    @GetMapping
    public List<PacienteDTO> findAll() {
        return servicio.findAll();
    }

    @GetMapping("/custom")
    public List<PacienteDTO> findAllCustom() {
        return servicio.findAllCustom();
    }

    @GetMapping("/{id}")
    public PacienteDTO findById(@PathVariable long id) {
        return servicio.findById(id);
    }

    @PostMapping
    public PacienteDTO add(@RequestBody PacienteDTO paciente) {
        return servicio.add(paciente);
    }

    @PutMapping("/{id}")
    public PacienteDTO update(@PathVariable long id, @RequestBody PacienteDTO paciente) {
        return servicio.update(paciente, id);
    }

    @DeleteMapping("/{id}")
    public PacienteDTO delete(@PathVariable long id) {
        return servicio.delete(id);
    }

    @PutMapping("/enable/{id}")
    public PacienteDTO enable(@PathVariable long id) {
        return servicio.enable(id);
    }
}
