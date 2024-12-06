package com.vhbv.consultorio.service.mappers;

import com.vhbv.consultorio.model.dtos.DoctorDTO;
import com.vhbv.consultorio.model.entities.Doctor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface DoctorMapper extends EntityMapper<DoctorDTO, Doctor> {
    DoctorDTO toDto(Doctor entity);

    Doctor toEntity(DoctorDTO dto);

}
