package com.example.egudanna.controller;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.UUID;

@RestController
public class FileUploadController {

    private final AmazonS3 amazonS3Client;

    @Autowired
    public FileUploadController(AmazonS3 amazonS3Client) {
        this.amazonS3Client = amazonS3Client;
    }

    @PostMapping("/multipart-files")
    public void uploadMultipleFile(@RequestParam(value = "file", name = "file") MultipartFile file) throws IOException {
        String objectKey = generateObjectKey(file.getOriginalFilename());

        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentType(file.getContentType());
        objectMetadata.setContentLength(file.getSize());

        PutObjectRequest putObjectRequest = new PutObjectRequest(
                "2024-egudanna-challenge",
                objectKey,
                file.getInputStream(),
                objectMetadata
        );

        amazonS3Client.putObject(putObjectRequest);


    }

    private String generateObjectKey(String originalFilename) {
        String uniqueID = UUID.randomUUID().toString();
        return uniqueID + "-" + originalFilename;
    }
}
