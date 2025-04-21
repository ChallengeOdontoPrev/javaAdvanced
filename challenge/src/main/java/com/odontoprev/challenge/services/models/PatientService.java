package com.odontoprev.challenge.services.models;

import com.odontoprev.challenge.domain.Patient;
import com.odontoprev.challenge.domain.dto.PatientDTO;
import com.odontoprev.challenge.repositories.PatientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Transactional
    public PatientDTO insert(PatientDTO patientDTO) {
        Patient patient = new Patient(patientDTO);
        patient.setCreatedAt(LocalDate.now());
        patient = patientRepository.save(patient);
        return new PatientDTO(patient);
    }

    @Transactional
    public void insertWithProcedure(PatientDTO patientDTO) {
        this.patientRepository.INSERT_PATIENT(patientDTO.getBirthDate(), patientDTO.getNumCard(), patientDTO.getName(), patientDTO.getRg());
    }

    @Transactional
    public void updateWithProcedure(PatientDTO patientDTO) {
        this.patientRepository.UPDATE_PATIENT(patientDTO.getId(), patientDTO.getBirthDate(), patientDTO.getNumCard(), patientDTO.getName(), patientDTO.getRg());
    }

    @Transactional
    public void deleteWithProcedure(Long id) {
        this.patientRepository.DELETE_PATIENT(id);
    }

    public List<PatientDTO> findAll() {
        return patientRepository.findAll().stream().map(PatientDTO::new).toList();
    }

    public PatientDTO findById(Long id) {
        return new PatientDTO(patientRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Paciente não encontrado !!")));
    }

    public PatientDTO findByIdOdontoPrev(Long numCard) {
        return new PatientDTO(patientRepository.findByNumCard(numCard).orElseThrow(() -> new NoSuchElementException("Paciente não encontrado !!")));
    }
}
