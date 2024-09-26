package com.challenge.odonto_prev.services;

import com.challenge.odonto_prev.domain.Clinica;
import com.challenge.odonto_prev.domain.dto.ClinicaDTO;
import com.challenge.odonto_prev.repositories.ClinicaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ClinicaService {

    @Autowired
    private ClinicaRepository clinicaRepository;

    @Transactional
    public ClinicaDTO insert(ClinicaDTO clinicaDTO) {
        Clinica clinica = new Clinica();
        BeanUtils.copyProperties(clinicaDTO, clinica);
        clinica = clinicaRepository.save(clinica);
        return new ClinicaDTO(clinica);
    }

    public List<ClinicaDTO> findAll() {
        return clinicaRepository.findAll().stream().map(ClinicaDTO::new).toList();
    }

    public ClinicaDTO findById(Long id) {
        return new ClinicaDTO(clinicaRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Clínica não encontrada")));
    }
}
