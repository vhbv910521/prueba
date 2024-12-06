package com.vhbv.consultorio.service.mappers;

import com.vhbv.consultorio.model.dtos.CitaDTO;
import com.vhbv.consultorio.model.entities.Cita;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {DoctorMapper.class, ConsultorioMapper.class})
public interface CitaMapper extends EntityMapper<CitaDTO, Cita> {
    @Mapping(source = "doctor.id", target = "doctorId")
    @Mapping(source = "consultorio.id", target = "consultorioId")
    CitaDTO toDto(Cita cita);

    Cita toEntity(CitaDTO citaDTO);

}
