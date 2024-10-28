package com.challenge.odonto_prev.services;

import com.challenge.odonto_prev.controllers.ProcedureStatusController;
import com.challenge.odonto_prev.domain.ProcedureStatus;
import com.challenge.odonto_prev.domain.ProcedureType;
import com.challenge.odonto_prev.domain.ProcedureValidation;
import com.challenge.odonto_prev.domain.dto.ProcedureStatusDTO;
import com.challenge.odonto_prev.domain.dto.ProcedureValidationDTO;
import com.challenge.odonto_prev.repositories.ProcedureValidationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

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

        if (procedureStatusService.findDefaultStatus("PENDENTE") == null){
            ProcedureStatusDTO procedureStatus = new ProcedureStatusDTO();
            procedureStatus.setName("PENDENTE");
            procedureStatus.setDescription("Procedimento pendente de validação");
            procedureStatus = procedureStatusService.insert(procedureStatus);
            procedureValidation.setProcedureStatus(new ProcedureStatus(procedureStatus));
        } else {
            procedureValidation.setProcedureStatus(new ProcedureStatus(
                procedureStatusService.findByName("PENDENTE")
            ));
        }

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
