package com.challenge.odonto_prev.services;

import com.challenge.odonto_prev.domain.ProcedureType;
import com.challenge.odonto_prev.domain.dto.ProcedureTypeDTO;
import com.challenge.odonto_prev.repositories.ProcedureTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProcedureTypeService {

    @Autowired
    private ProcedureTypeRepository procedureTypeRepository;

    @Transactional
    public ProcedureTypeDTO insert(ProcedureTypeDTO procedureTypeDTO) {
        ProcedureType procedureType = new ProcedureType(procedureTypeDTO);
        procedureType = procedureTypeRepository.save(procedureType);
        return new ProcedureTypeDTO(procedureType);
    }

    public List<ProcedureTypeDTO> findAll() {
        return procedureTypeRepository.findAll().stream().map(ProcedureTypeDTO::new).toList();
    }

    public ProcedureTypeDTO findById(Long id) {
        return new ProcedureTypeDTO(procedureTypeRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Tipo de Procedimento não encontrado !!")));
    }
}