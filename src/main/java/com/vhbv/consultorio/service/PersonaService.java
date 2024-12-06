package com.vhbv.consultorio.service;

import com.vhbv.consultorio.model.entities.Persona;
import com.vhbv.consultorio.service.repositories.PersonaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService {
    private final PersonaRepository repository;

    public PersonaService(PersonaRepository repository) {
        this.repository = repository;
    }

    public void create(Persona persona) {
        repository.save(persona);
    }

    public void update(Persona persona) {
        repository.save(persona);
    }

    public List<Persona> list(){
        return repository.findAll();
    }

}
