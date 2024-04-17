package com.kuskakuy.demo.restcontroller.gestion;

import com.kuskakuy.demo.dto.gestion.ServicioDTO;
import com.kuskakuy.demo.service.gestion.ServicioService;
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
@RequestMapping("/servicio")
public class ServicioRestController {

    @Autowired
    private ServicioService servicio;

    @GetMapping
    public List<ServicioDTO> findAll() {
        return servicio.findAll();
    }

    @GetMapping("/custom")
    public List<ServicioDTO> findAllCustom() {
        return servicio.findAllCustom();
    }

    @GetMapping("/{id}")
    public ServicioDTO findById(@PathVariable long id) {
        return servicio.findById(id);
    }

    @PostMapping
    public ServicioDTO add(@RequestBody ServicioDTO serv) {
        return servicio.add(serv);
    }

    @PutMapping("/{id}")
    public ServicioDTO update(@PathVariable long id, @RequestBody ServicioDTO serv) {
        return servicio.update(serv, id);
    }

    @DeleteMapping("/{id}")
    public ServicioDTO delete(@PathVariable long id) {
        return servicio.delete(id);
    }

    @PutMapping("/enable/{id}")
    public ServicioDTO enable(@PathVariable long id) {
        return servicio.enable(id);
    }
}
