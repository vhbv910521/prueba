package com.vhbv.consultorio.controller;

import com.vhbv.consultorio.model.dtos.CitaDTO;
import com.vhbv.consultorio.service.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/citas")
public class CitaController {
    private final CitaService service;

    @Autowired
    public CitaController(CitaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CitaDTO> create(@RequestBody CitaDTO dto) throws Exception {
        CitaDTO response = service.create(dto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<CitaDTO> update(@RequestBody CitaDTO dto) throws Exception {
        CitaDTO response = service.update(dto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CitaDTO>> findAll() {
        List<CitaDTO> list = service.list();
        return new ResponseEntity<>(list, HttpStatus.ACCEPTED);
    }

    @GetMapping("/doctor/{id}")
    public ResponseEntity<List<CitaDTO>> findAllByDoctor(@PathVariable("id") Long id) {
        List<CitaDTO> list = service.listByDoctor(id);
        return new ResponseEntity<>(list, HttpStatus.ACCEPTED);
    }
}
