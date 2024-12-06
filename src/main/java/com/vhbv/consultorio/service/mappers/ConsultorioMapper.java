package com.vhbv.consultorio.service.mappers;

import com.vhbv.consultorio.model.dtos.ConsultorioDTO;
import com.vhbv.consultorio.model.entities.Consultorio;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface ConsultorioMapper extends EntityMapper<ConsultorioDTO, Consultorio> {
    ConsultorioDTO toDto(Consultorio entity);
    Consultorio toEntity(ConsultorioDTO dto);

}
