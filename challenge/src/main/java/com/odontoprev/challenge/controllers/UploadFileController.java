package com.odontoprev.challenge.controllers;

import com.odontoprev.challenge.services.UploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/validate")
public class UploadFileController {

    @Autowired
    private UploadFileService uploadFileService;

    @PostMapping("/{idAppointment}")
    public ResponseEntity<String> uploadFiles(
            @RequestParam("fileStart") MultipartFile fileStart,
            @RequestParam("fileEnd") MultipartFile fileEnd,
            @PathVariable("idAppointment") Long idAppointment) {
        try {
            if (fileStart.isEmpty() || fileEnd.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("Os arquivos fileStart e fileEnd são obrigatórios.");
            }

            String result = uploadFileService.uploadFiles(fileStart, fileEnd, idAppointment);
            return ResponseEntity.ok(result);
        } catch (IOException e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro interno ao processar os arquivos.");
        }
    }

}


