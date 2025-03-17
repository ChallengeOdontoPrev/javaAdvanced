package com.odontoprev.challenge.services;


import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UploadFileService {

    @Value("${azure.container-name}")
    private String azureContainerName;

    private final BlobServiceClient blobServiceClient;

    public UploadFileService(BlobServiceClient blobServiceClient) {
        this.blobServiceClient = blobServiceClient;
    }

    public List<String> uploadFiles(MultipartFile fileStart, MultipartFile fileEnd, Long idAppointment) throws IOException {

        if (fileStart.isEmpty() || fileEnd.isEmpty()) {
            throw new IOException("Ambos os arquivos devem ser enviados.");
        }

        BlobContainerClient blobContainerClient = blobServiceClient.getBlobContainerClient(azureContainerName);

        String startObjectName = idAppointment + "/start_" + idAppointment + extractExtension(fileStart.getOriginalFilename());
        String endObjectName = idAppointment + "/end_" + idAppointment + extractExtension(fileEnd.getOriginalFilename());

        BlobClient startBlobClient = blobContainerClient.getBlobClient(startObjectName);
        BlobClient endBlobClient = blobContainerClient.getBlobClient(endObjectName);

        startBlobClient.upload(fileStart.getInputStream(), fileStart.getSize(), true);
        endBlobClient.upload(fileEnd.getInputStream(), fileEnd.getSize(), true);

        return List.of(startBlobClient.getBlobUrl(), endBlobClient.getBlobUrl());
    }

    private String extractExtension(String filename) {
        Pattern pattern = Pattern.compile("\\.\\w+$");
        Matcher matcher = pattern.matcher(filename);
        return matcher.find() ? matcher.group() : "error";
    }
}
