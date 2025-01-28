package com.challenge.odonto_prev.services;

import com.challenge.odonto_prev.domain.ProcedureStatus;
import com.challenge.odonto_prev.domain.ProcedureType;
import com.challenge.odonto_prev.domain.ProcedureValidation;
import com.challenge.odonto_prev.domain.dto.ProcedureValidationDTO;
import com.challenge.odonto_prev.repositories.ProcedureValidationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProcedureValidationService {

    @Autowired
    private ProcedureValidationRepository procedureValidationRepository;

    @Autowired
    private ProcedureStatusService procedureStatusService;

    @Autowired
    private ProcedureTypeService procedureTypeService;

    @Transactional
    public ProcedureValidationDTO insert(ProcedureValidationDTO procedureValidationDTO, Long procedureTypeId) {
        ProcedureValidation procedureValidation = new ProcedureValidation(procedureValidationDTO);

        procedureValidation.setProcedureStatus(new ProcedureStatus(
                procedureStatusService.findByName("Em Análise de Validação")
        ));

        procedureValidation.setProcedureType(new ProcedureType(
                this.procedureTypeService.findById(procedureTypeId)
        ));
        procedureValidation = procedureValidationRepository.save(procedureValidation);
        return new ProcedureValidationDTO(procedureValidation);
    }

    public List<ProcedureValidationDTO> findAll() {
        return procedureValidationRepository.findAll().stream().map(ProcedureValidationDTO::new).toList();
    }

    public ProcedureValidationDTO findById(Long id) {
        return new ProcedureValidationDTO(procedureValidationRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Procedimento não encontrado !!")));
    }

    @Transactional
    public ProcedureValidationDTO updateStatus(Long id, String status) {
        ProcedureValidation procedureValidation = new ProcedureValidation(
                this.procedureValidationRepository.findById(id)
                        .orElseThrow(() -> new NoSuchElementException("Procedimento não encontrado !!"))
        );
        procedureValidation.setProcedureStatus(new ProcedureStatus(
                procedureStatusService.findByName(status)
        ));
        procedureValidation = procedureValidationRepository.save(procedureValidation);

        return new ProcedureValidationDTO(procedureValidation);
    }

    @Transactional
    public void delete(ProcedureValidation procedureValidation) {
        this.procedureValidationRepository.delete(procedureValidation);
    }
}
