package com.vhbv.consultorio.controller;

import com.vhbv.consultorio.model.dtos.DoctorDTO;
import com.vhbv.consultorio.model.entities.Doctor;
import com.vhbv.consultorio.model.entities.Persona;
import com.vhbv.consultorio.service.DoctorService;
import com.vhbv.consultorio.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctores")
public class DoctorController {
    private final DoctorService service;

    @Autowired
    public DoctorController(DoctorService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<DoctorDTO> create(@RequestBody DoctorDTO dto) {
        DoctorDTO response = service.create(dto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<DoctorDTO> update(@RequestBody DoctorDTO entity) {
        DoctorDTO response = service.create(entity);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<DoctorDTO>> findAll() {
        List<DoctorDTO> list = service.list();
        return new ResponseEntity<>(list, HttpStatus.ACCEPTED);
    }
}
