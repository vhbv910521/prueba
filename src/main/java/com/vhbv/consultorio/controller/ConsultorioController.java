package com.vhbv.consultorio.controller;

import com.vhbv.consultorio.model.dtos.ConsultorioDTO;
import com.vhbv.consultorio.service.ConsultorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultorios")
public class ConsultorioController {
    private final ConsultorioService service;

    @Autowired
    public ConsultorioController(ConsultorioService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ConsultorioDTO> create(@RequestBody ConsultorioDTO entity) {
        ConsultorioDTO response = service.create(entity);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<ConsultorioDTO> update(@RequestBody ConsultorioDTO entity) {
        ConsultorioDTO response = service.update(entity);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ConsultorioDTO>> findAll() {
        List<ConsultorioDTO> list = service.list();
        return new ResponseEntity<>(list, HttpStatus.ACCEPTED);
    }
}
