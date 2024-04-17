package com.kuskakuy.demo.restcontroller.proceso;

import com.kuskakuy.demo.dto.proceso.RegistroCitaDTO;
import com.kuskakuy.demo.service.proceso.RegistroCitaService;
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
@RequestMapping("/registrocita")
public class RegistroCitaRestController {

    @Autowired
    private RegistroCitaService servicio;

    @GetMapping
    public List<RegistroCitaDTO> findAll() {
        return servicio.findAll();
    }

    @GetMapping("/custom")
    public List<RegistroCitaDTO> findAllCustom() {
        return servicio.findAllCustom();
    }

    @GetMapping("/{id}")
    public RegistroCitaDTO findById(@PathVariable long id) {
        return servicio.findById(id);
    }

    @PostMapping
    public RegistroCitaDTO add(@RequestBody RegistroCitaDTO cita) {
        return servicio.add(cita);
    }

    @PutMapping("/{id}")
    public RegistroCitaDTO update(@RequestBody RegistroCitaDTO cita, @PathVariable long id) {
        return servicio.update(cita, id);
    }

    @DeleteMapping("/{id}")
    public RegistroCitaDTO delete(@PathVariable long id) {
        return servicio.delete(id);
    }

    @PutMapping("/enable/{id}")
    public RegistroCitaDTO enable(@PathVariable long id) {
        return servicio.enable(id);
    }
}
