package com.odontoprev.challenge.controllers;

import com.odontoprev.challenge.domain.dto.AppointmentDTO;
import com.odontoprev.challenge.domain.dto.AppointmentResponseDTO;
import com.odontoprev.challenge.domain.dto.UpdateAppointmentDTO;
import com.odontoprev.challenge.domain.projection.AuditProjection;
import com.odontoprev.challenge.services.MessageSenderService;
import com.odontoprev.challenge.services.UploadFileService;
import com.odontoprev.challenge.services.models.AppointmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(path = "/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private UploadFileService uploadFileService;

    @Autowired
    private MessageSenderService messageSenderService;

    @PostMapping
    public ResponseEntity<AppointmentDTO> insert(@RequestBody @Valid AppointmentDTO appointmentDTO) {
        AppointmentDTO appointment = appointmentService.insert(appointmentDTO);
        return ResponseEntity.ok(appointment);
    }

    @PostMapping("/{idAppointment}/validate")
    public ResponseEntity<String> validateAppointment(
            @RequestParam("fileStart") MultipartFile fileStart,
            @RequestParam("fileEnd") MultipartFile fileEnd,
            @PathVariable("idAppointment") Long idAppointment) {
        try {
            if (fileStart.isEmpty() || fileEnd.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("Os arquivos fileStart e fileEnd são obrigatórios.");
            }

            List<String> result = uploadFileService.uploadFiles(fileStart, fileEnd, idAppointment);

            this.appointmentService.updateProcedureValidation(idAppointment, result.getFirst(), result.getLast());

            String message = this.messageSenderService.processAndSendMessage(
                    this.appointmentService.findById(idAppointment),
                    result.getFirst(),
                    result.getLast()
            );

            return ResponseEntity.ok("Consulta enviada para validação.\nMensagem: " + message);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro interno ao processar os arquivos.");
        }
    }

    @GetMapping
    public ResponseEntity<List<AppointmentResponseDTO>> findAll() {
        List<AppointmentResponseDTO> appointments = appointmentService.findAll().stream().map(AppointmentResponseDTO::new).toList();
        return ResponseEntity.ok(appointments);
    }

    @GetMapping("/status")
    public ResponseEntity<List<AppointmentResponseDTO>> findAllByStatus(@RequestParam String status) {
        List<AppointmentResponseDTO> appointments = appointmentService.findAllByStatus(status).stream().map(AppointmentResponseDTO::new).toList();
        return ResponseEntity.ok(appointments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppointmentResponseDTO> findById(@PathVariable Long id) {
        AppointmentResponseDTO appointment = new AppointmentResponseDTO(appointmentService.findById(id));
        return ResponseEntity.ok(appointment);
    }

    @GetMapping("byPatientIdOdontoPrev/{idOdontoPrev}")
    public ResponseEntity<List<AppointmentResponseDTO>> findByPatientIdOdontoPrev(@PathVariable Long idOdontoPrev) {
        return ResponseEntity.ok(this.appointmentService.findAllByPatientNumCard(idOdontoPrev));
    }

    @GetMapping("/appointmentsAudit")
    public ResponseEntity<List<AuditProjection>> findAllAppointmentAudits() {
        return ResponseEntity.ok(this.appointmentService.findAllAppointmentAudits());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        appointmentService.deleteById(id);
        return ResponseEntity.ok("Consulta deletada com sucesso");
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody @Valid UpdateAppointmentDTO appointmentDTO) {
        appointmentService.updateProcedureType(id, appointmentDTO);
        return ResponseEntity.ok("Consulta atualizada com sucesso");
    }
}
