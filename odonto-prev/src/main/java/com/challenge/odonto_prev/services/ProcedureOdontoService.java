package com.challenge.odonto_prev.services;

import com.challenge.odonto_prev.domain.ProcedureOdonto;
import com.challenge.odonto_prev.domain.dto.ProcedureOdontoDTO;
import com.challenge.odonto_prev.repositories.ProcedureOdontoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProcedureOdontoService {

    @Autowired
    private ProcedureOdontoRepository procedureOdontoRepository;

    @Transactional
    public ProcedureOdontoDTO insert(ProcedureOdontoDTO procedureOdontoDTO) {
        ProcedureOdonto procedureOdonto = new ProcedureOdonto(procedureOdontoDTO);
        procedureOdonto = procedureOdontoRepository.save(procedureOdonto);
        return new ProcedureOdontoDTO(procedureOdonto);
    }

    public List<ProcedureOdontoDTO> findAll() {
        return procedureOdontoRepository.findAll().stream().map(ProcedureOdontoDTO::new).toList();
    }

    public ProcedureOdontoDTO findById(Long id) {
        return new ProcedureOdontoDTO(procedureOdontoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Procedimento não encontrado !!")));
    }
}
