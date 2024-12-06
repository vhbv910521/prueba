package com.vhbv.consultorio.service;

import com.vhbv.consultorio.model.dtos.CitaDTO;
import com.vhbv.consultorio.model.entities.Cita;
import com.vhbv.consultorio.service.mappers.CitaMapper;
import com.vhbv.consultorio.service.repositories.CitaRepository;
import com.vhbv.consultorio.service.repositories.ConsultorioRepository;
import com.vhbv.consultorio.service.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitaService {
    private final CitaRepository repository;
    private final CitaMapper mapper;
    private final ConsultorioRepository consultorioRepository;
    private final DoctorRepository doctorRepository;

    @Autowired
    public CitaService(CitaRepository repository, CitaMapper mapper, ConsultorioRepository consultorioRepository, DoctorRepository doctorRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.consultorioRepository = consultorioRepository;
        this.doctorRepository = doctorRepository;
    }

    public CitaDTO create(CitaDTO dto) throws Exception {
        List<Cita> citas = repository.findCitaByDoctorId(dto.getDoctorId());
        if (citas.size() >= 8) {
            throw new Exception("El doctor ya no puede atender mas citas.");
        }
        List<Cita> horario = repository.findCitaByHorario(dto.getHorario(), dto.getConsultorioId());
        if (!horario.isEmpty()) {
            throw new Exception("Ya existe una cita agendada en el horario.");
        }
        Cita entity = mapper.toEntity(dto);
        entity.setConsultorio(consultorioRepository.getReferenceById(dto.getConsultorioId()));
        entity.setDoctor(doctorRepository.getReferenceById(dto.getDoctorId()));
        return mapper.toDto(repository.save(entity));
    }

    public CitaDTO update(CitaDTO dto) throws Exception {
        Cita entity = mapper.toEntity(dto);
        List<Cita> horario = repository.findCitaByHorario(dto.getHorario(), dto.getConsultorioId());
        if (!horario.isEmpty()) {
            throw new Exception("Ya existe una cita agendada en el horario.");
        }
        entity.setConsultorio(consultorioRepository.getReferenceById(dto.getConsultorioId()));
        entity.setDoctor(doctorRepository.getReferenceById(dto.getDoctorId()));
        return mapper.toDto(repository.save(entity));
    }

    public List<CitaDTO> list() {
        return mapper.toDto(repository.findAll());
    }

    public List<CitaDTO> listByDoctor(Long id) {
        return mapper.toDto(repository.findCitaByDoctorId(id));
    }

}
