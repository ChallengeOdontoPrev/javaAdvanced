package com.odontoprev.challenge.services;

import com.odontoprev.challenge.domain.*;
import com.odontoprev.challenge.domain.dto.AppointmentDTO;
import com.odontoprev.challenge.domain.dto.ProcedureValidationDTO;
import com.odontoprev.challenge.repositories.AppointmentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private PatientService patientService;

    @Autowired
    private UserService userService;

    @Autowired
    private ProcedureValidationService procedureValidationService;

    @Autowired
    private ProcedureTypeService procedureTypeService;

    @Autowired
    private AuthService authService;

    @Transactional
    public AppointmentDTO insert(AppointmentDTO appointmentDTO) {
        Appointment appointment = new Appointment();
        BeanUtils.copyProperties(appointmentDTO, appointment);
        appointment.setPatient(new Patient(
                patientService.findById(appointmentDTO.getPatientId())
        ));

        User user = this.userService.findById(appointmentDTO.getDentistId());

        appointment.setUser(user);
        appointment.setClinic(user.getClinic());

        appointment.setProcedureType(new ProcedureType(
                this.procedureTypeService.findById(appointmentDTO.getProcedureTypeId())
        ));

        ProcedureValidationDTO procedureValidationDTO = new ProcedureValidationDTO();
        appointment.setProcedureValidation(new ProcedureValidation(
                this.procedureValidationService
                        .insert(procedureValidationDTO, appointment.getProcedureType().getId())
        ));

        appointment.setCreatedAt(LocalDateTime.now());
        appointment = appointmentRepository.save(appointment);
        return new AppointmentDTO(appointment);
    }

    public List<Appointment> findAll() {
        return appointmentRepository.findAll();
    }

    public List<Appointment> findAllByStatus(String status) {
        return appointmentRepository.findAllByStatus(status);
    }

    public Appointment findById(Long id) {
        return appointmentRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Consulta não encontrada"));
    }

    public void updateProcedureValidation(Long idAppointment , String imgUrlInitial, String imgUrlFinal) {
        Appointment appointment = this.appointmentRepository.findById(idAppointment)
                .orElseThrow(() -> new NoSuchElementException("Consulta não encontrada"));

        this.procedureValidationService.updateAddImages(imgUrlInitial, imgUrlFinal, appointment.getProcedureValidation().getId());
    }

    @Transactional
    public void deleteById(Long id) {
        Appointment appointment = this.findById(id);
        appointmentRepository.delete(appointment);
        procedureValidationService.delete(appointment.getProcedureValidation());
    }

}
