package com.vhbv.consultorio.service;

import com.vhbv.consultorio.model.dtos.DoctorDTO;
import com.vhbv.consultorio.model.entities.Doctor;
import com.vhbv.consultorio.service.mappers.DoctorMapper;
import com.vhbv.consultorio.service.repositories.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    private final DoctorRepository repository;
    private final DoctorMapper mapper;

    public DoctorService(DoctorRepository repository, DoctorMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public DoctorDTO create(DoctorDTO dto) {
        Doctor entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    public DoctorDTO update(DoctorDTO dto) {
        Doctor entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    public List<DoctorDTO> list() {
        return mapper.toDto(repository.findAll());
    }

}
