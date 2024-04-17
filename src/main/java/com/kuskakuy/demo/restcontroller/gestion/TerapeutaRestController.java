package com.kuskakuy.demo.restcontroller.gestion;

import com.kuskakuy.demo.dto.gestion.TerapeutaDTO;
import com.kuskakuy.demo.service.gestion.TerapeutaService;
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
@RequestMapping("/terapeuta")
public class TerapeutaRestController {

    @Autowired
    private TerapeutaService servicio;

    @GetMapping
    public List<TerapeutaDTO> findAll() {
        return servicio.findAll();
    }

    @GetMapping("/custom")
    public List<TerapeutaDTO> findAllCustom() {
        return servicio.findAllCustom();
    }

    @GetMapping("/{id}")
    public TerapeutaDTO findById(@PathVariable long id) {
        return servicio.findById(id);
    }

    @PostMapping
    public TerapeutaDTO add(@RequestBody TerapeutaDTO terapeuta) {
        return servicio.add(terapeuta);
    }

    @PutMapping("/{id}")
    public TerapeutaDTO update(@PathVariable long id, @RequestBody TerapeutaDTO terapeuta) {
        return servicio.update(terapeuta, id);
    }

    @DeleteMapping("/{id}")
    public TerapeutaDTO delete(@PathVariable long id) {
        return servicio.delete(id);
    }

    @PutMapping("/enable/{id}")
    public TerapeutaDTO enable(@PathVariable long id) {
        return servicio.enable(id);
    }
}
