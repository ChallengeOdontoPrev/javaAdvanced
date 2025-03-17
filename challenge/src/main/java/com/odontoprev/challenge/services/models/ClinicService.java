package com.odontoprev.challenge.services.models;

import com.odontoprev.challenge.domain.Address;
import com.odontoprev.challenge.domain.Clinic;
import com.odontoprev.challenge.domain.dto.ClinicDTO;
import com.odontoprev.challenge.repositories.AddressRepository;
import com.odontoprev.challenge.repositories.ClinicRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ClinicService {

    @Autowired
    private ClinicRepository clinicRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Transactional
    public ClinicDTO insert(ClinicDTO clinicDTO) {
        Clinic clinic = new Clinic();
        BeanUtils.copyProperties(clinicDTO, clinic);

        Address address = new Address(clinicDTO.getAddress());
        address = addressRepository.save(address);
        clinic.setAddress(address);

        clinic = clinicRepository.save(clinic);
        return new ClinicDTO(clinic);
    }

    public List<ClinicDTO> findAll() {
        return clinicRepository.findAll().stream().map(ClinicDTO::new).toList();
    }

    public ClinicDTO findById(Long id) {
        return new ClinicDTO(clinicRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Clínica não encontrada")));
    }
}
