package com.challenge.odonto_prev.services;

import com.challenge.odonto_prev.domain.Patient;
import com.challenge.odonto_prev.domain.dto.PatientDTO;
import com.challenge.odonto_prev.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Transactional
    public PatientDTO insert(PatientDTO patientDTO){
        Patient patient = new Patient(patientDTO);
        patient = patientRepository.save(patient);
        return new PatientDTO(patient);
    }

    public List<PatientDTO> findAll(){
        return patientRepository.findAll().stream().map(PatientDTO::new).toList();
    }

}
