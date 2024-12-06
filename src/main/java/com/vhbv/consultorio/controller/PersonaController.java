package com.vhbv.consultorio.controller;

import com.vhbv.consultorio.model.entities.Persona;
import com.vhbv.consultorio.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personas")
public class PersonaController {
    private final PersonaService service;

    @Autowired
    public PersonaController(PersonaService service) {
        this.service = service;
    }

    @PostMapping
    public void create(@RequestBody Persona persona) {
        service.create(persona);
    }

    @PutMapping
    public void update(@RequestBody Persona persona) {
        service.update(persona);
    }

    @GetMapping
    public List<Persona> findAll() {
        return service.list();
    }
}
