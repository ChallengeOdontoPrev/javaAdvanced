package com.challenge.odonto_prev.services;

import com.challenge.odonto_prev.domain.Appointment;
import com.challenge.odonto_prev.domain.Patient;
import com.challenge.odonto_prev.domain.ProcedureOdonto;
import com.challenge.odonto_prev.domain.User;
import com.challenge.odonto_prev.domain.dto.AppointmentDTO;
import com.challenge.odonto_prev.enums.UserRole;
import com.challenge.odonto_prev.repositories.AppointmentRepository;
import com.challenge.odonto_prev.services.exceptions.InvalidCredentialsException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private PatientService patientService;

    @Autowired
    private UserService userService;

    @Autowired
    private ProcedureOdontoService procedureOdontoService;

    @Transactional
    public AppointmentDTO insert(AppointmentDTO appointmentDTO) {
        Appointment appointment = new Appointment();
        BeanUtils.copyProperties(appointmentDTO, appointment);
        appointment.setPatient(new Patient(
                patientService.findById(appointmentDTO.getPatientId())
        ));
        User user = new User(userService.findById(appointmentDTO.getUserId()));

        if (user.getRole() != UserRole.DENTISTA) {
            throw new InvalidCredentialsException("O usuário informado não é um dentista");
        }

        appointment.setUser(user);
        appointment.setClinic(user.getClinic());
        appointment.setProcedureOdonto(new ProcedureOdonto(
                this.procedureOdontoService.findById(appointmentDTO.getProcedureOdontoId())
        ));
        appointment.setCreatedAt(LocalDateTime.now());
        appointment = appointmentRepository.save(appointment);
        return new AppointmentDTO(appointment);
    }

    public List<AppointmentDTO> findAll() {
        return appointmentRepository.findAll().stream().map(AppointmentDTO::new).toList();
    }

}
