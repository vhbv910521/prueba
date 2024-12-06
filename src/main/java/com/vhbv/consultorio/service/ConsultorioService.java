package com.vhbv.consultorio.service;

import com.vhbv.consultorio.model.dtos.ConsultorioDTO;
import com.vhbv.consultorio.model.entities.Consultorio;
import com.vhbv.consultorio.service.mappers.ConsultorioMapper;
import com.vhbv.consultorio.service.repositories.ConsultorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultorioService {
    private final ConsultorioRepository repository;
    private final ConsultorioMapper mapper;

    @Autowired
    public ConsultorioService(ConsultorioRepository repository, ConsultorioMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public ConsultorioDTO create(ConsultorioDTO dto) {
        Consultorio entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    public ConsultorioDTO update(ConsultorioDTO dto) {
        Consultorio entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    public List<ConsultorioDTO> list() {
        return mapper.toDto(repository.findAll());
    }

}
