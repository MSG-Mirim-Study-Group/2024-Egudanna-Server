package com.example.egudanna.controller;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.example.egudanna.service.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/api/s3")
public class S3Controller {

    private final AmazonS3 amazonS3Client;
    private final S3Service s3Service;

    @Autowired
    public S3Controller(AmazonS3 amazonS3Client, S3Service s3Service) {
        this.amazonS3Client = amazonS3Client;
        this.s3Service = s3Service;
    }

    @PostMapping("/upload")
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

    @GetMapping("/download/local")
    public String downloadFileToLocal(@RequestParam("bucket") String bucketName, @RequestParam("key") String key) {
        try {
            s3Service.downloadFileToLocal(bucketName, key);
            return "File downloaded to local successfully.";
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to download file to local: " + e.getMessage();
        }
    }

    @GetMapping("/download/byte")
    public byte[] downloadFileToByteArray(@RequestParam("bucket") String bucketName, @RequestParam("key") String key) {
        try {
            return s3Service.downloadFileToByteArray(bucketName, key);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private String generateObjectKey(String originalFilename) {
        String uniqueID = UUID.randomUUID().toString();
        return uniqueID + "-" + originalFilename;
    }
}
