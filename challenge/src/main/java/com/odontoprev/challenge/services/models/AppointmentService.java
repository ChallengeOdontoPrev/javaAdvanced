package com.odontoprev.challenge.services.models;

import com.odontoprev.challenge.domain.*;
import com.odontoprev.challenge.domain.dto.AppointmentDTO;
import com.odontoprev.challenge.domain.dto.ProcedureValidationDTO;
import com.odontoprev.challenge.domain.dto.UpdateAppointmentDTO;
import com.odontoprev.challenge.domain.projection.AuditProjection;
import com.odontoprev.challenge.enums.AppointmentStatus;
import com.odontoprev.challenge.repositories.AppointmentRepository;
import com.odontoprev.challenge.services.AuthService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final PatientService patientService;
    private final UserService userService;
    private final ProcedureValidationService procedureValidationService;
    private final ProcedureTypeService procedureTypeService;

    public AppointmentService(AppointmentRepository appointmentRepository, PatientService patientService, UserService userService, ProcedureValidationService procedureValidationService, ProcedureTypeService procedureTypeService, AuthService authService) {
        this.appointmentRepository = appointmentRepository;
        this.patientService = patientService;
        this.userService = userService;
        this.procedureValidationService = procedureValidationService;
        this.procedureTypeService = procedureTypeService;
    }

    @Transactional
    public AppointmentDTO insert(AppointmentDTO appointmentDTO) {
        Appointment appointment = new Appointment();
        BeanUtils.copyProperties(appointmentDTO, appointment);

        appointment.setStatus(AppointmentStatus.SCHEDULED);

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

    @Transactional
    public void updateProcedureValidation(Long idAppointment, String imgUrlInitial, String imgUrlFinal) {
        Appointment appointment = this.appointmentRepository.findById(idAppointment)
                .orElseThrow(() -> new NoSuchElementException("Consulta não encontrada"));

        appointment.setStatus(AppointmentStatus.FINISHED);

        this.appointmentRepository.save(appointment);

        this.procedureValidationService.updateAddImages(imgUrlInitial, imgUrlFinal, appointment.getProcedureValidation().getId());
    }

    @Transactional
    public void updateProcedureType(Long idAppointment, UpdateAppointmentDTO appointmentDTO) {
        Appointment appointment = this.appointmentRepository.findById(idAppointment)
                .orElseThrow(() -> new NoSuchElementException("Consulta não encontrada"));

        appointment.setDateAppointment(appointmentDTO.getDateAppointment());
        appointment.setTimeAppointment(appointmentDTO.getTimeAppointment());

        ProcedureType procedureType = new ProcedureType(this.procedureTypeService.findById(appointmentDTO.getProcedureTypeId()));

        appointment.setProcedureType(procedureType);

        User user = this.userService.findById(appointmentDTO.getDentistId());

        appointment.setUser(user);

        appointmentRepository.save(appointment);
    }

    public List<AuditProjection> findAllAppointmentAudits() {
        return appointmentRepository.findAllAppointmentAudits();
    }

    @Transactional
    public void deleteById(Long id) {
        Appointment appointment = this.findById(id);
        appointmentRepository.delete(appointment);
        procedureValidationService.delete(appointment.getProcedureValidation());
    }

}
