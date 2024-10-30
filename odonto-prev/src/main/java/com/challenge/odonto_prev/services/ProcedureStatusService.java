package com.challenge.odonto_prev.services;

import com.challenge.odonto_prev.domain.ProcedureStatus;
import com.challenge.odonto_prev.domain.dto.ProcedureStatusDTO;
import com.challenge.odonto_prev.repositories.ProcedureStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProcedureStatusService {

    @Autowired
    private ProcedureStatusRepository procedureStatusRepository;

    @Transactional
    public ProcedureStatusDTO insert(ProcedureStatusDTO procedureStatusDTO) {
        ProcedureStatus procedureStatus = new ProcedureStatus(procedureStatusDTO);
        procedureStatus = procedureStatusRepository.save(procedureStatus);
        return new ProcedureStatusDTO(procedureStatus);
    }

    public List<ProcedureStatusDTO> findAll() {
        return procedureStatusRepository.findAll().stream().map(ProcedureStatusDTO::new).toList();
    }

    public ProcedureStatusDTO findById(Long id) {
        return new ProcedureStatusDTO(procedureStatusRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Status de Procedimento não encontrado !!")));
    }

    public ProcedureStatusDTO findByName(String name) {
        return new ProcedureStatusDTO(procedureStatusRepository.findByName(name)
                .orElseThrow(() -> new NoSuchElementException("Status de Procedimento não encontrado !!")));
    }

    public ProcedureStatus findDefaultStatus(String name) {
        return procedureStatusRepository.findByName(name)
                .orElse(null);
    }
}
