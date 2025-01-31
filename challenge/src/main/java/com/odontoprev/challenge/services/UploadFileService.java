package com.odontoprev.challenge.services;


import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UploadFileService {

    @Value("${test.project-id}")
    private String projectId;
    @Value("${test.bucket-name}")
    private String bucketName;

    public List<String> uploadFiles(MultipartFile fileStart, MultipartFile fileEnd, Long idAppointment) throws IOException {

        if (fileStart.isEmpty() || fileEnd.isEmpty()) {
            throw new IOException("Ambos os arquivos devem ser enviados.");
        }

        Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();

        String startObjectName = idAppointment + "/start_" + idAppointment;
        startObjectName += extractExtension(fileStart.getOriginalFilename());

        String endObjectName = idAppointment + "/end_" + idAppointment;
        endObjectName += extractExtension(fileEnd.getOriginalFilename());

        BlobId startBlobId = BlobId.of(bucketName, startObjectName);
        BlobInfo startBlobInfo = BlobInfo.newBuilder(startBlobId).build();
        storage.createFrom(startBlobInfo, fileStart.getInputStream());

        BlobId endBlobId = BlobId.of(bucketName, endObjectName);
        BlobInfo endBlobInfo = BlobInfo.newBuilder(endBlobId).build();
        storage.createFrom(endBlobInfo, fileEnd.getInputStream());

        return List.of(startObjectName, endObjectName);
    }

    private String extractExtension(String filename) {
        Pattern pattern = Pattern.compile("\\.\\w+$");
        Matcher matcher = pattern.matcher(filename);
        return matcher.find() ? matcher.group() : "error";
    }
}
