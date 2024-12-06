package com.vhbv.consultorio.service.repositories;

import com.vhbv.consultorio.model.entities.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Long> {

    @Query("select c " +
            "from Cita c " +
            "where c.horario = :horario " +
            "and c.consultorio.id = :consultorioId"
    )
    List<Cita> findCitaByHorario(Timestamp horario, Long consultorioId);

    List<Cita> findCitaByDoctorId(Long doctorId);
}
