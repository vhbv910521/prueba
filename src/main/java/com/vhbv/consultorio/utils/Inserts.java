package com.vhbv.consultorio.utils;

import com.vhbv.consultorio.model.dtos.ConsultorioDTO;
import com.vhbv.consultorio.model.dtos.DoctorDTO;
import com.vhbv.consultorio.model.entities.Consultorio;
import com.vhbv.consultorio.model.entities.Doctor;
import com.vhbv.consultorio.service.ConsultorioService;
import com.vhbv.consultorio.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Inserts implements CommandLineRunner {

    private final DoctorService doctorService;
    private final ConsultorioService consultorioService;

    @Autowired
    public Inserts(DoctorService doctorService, ConsultorioService consultorioService) {
        this.doctorService = doctorService;
        this.consultorioService = consultorioService;
    }

    @Override
    public void run(String... args) throws Exception {
        DoctorDTO doctor1 = new DoctorDTO("Juan", "Perez", "Morales");
        doctorService.create(doctor1);
        DoctorDTO doctor2 = new DoctorDTO("Pedro", "Reyes", "Morales");
        doctorService.create(doctor2);
        DoctorDTO doctor3 = new DoctorDTO("Diego", "Diaz", "Morales");
        doctorService.create(doctor3);
        ConsultorioDTO consultorio1 = new ConsultorioDTO("001", "P1");
        consultorioService.create(consultorio1);
        ConsultorioDTO consultorio2 = new ConsultorioDTO("001", "P2");
        consultorioService.create(consultorio2);
        ConsultorioDTO consultorio3 = new ConsultorioDTO("001", "P3");
        consultorioService.create(consultorio3);
    }
}
