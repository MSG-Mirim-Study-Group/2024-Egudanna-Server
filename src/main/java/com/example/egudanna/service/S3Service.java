package com.example.egudanna.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class S3Service {

    private final AmazonS3 amazonS3;

    @Autowired
    public S3Service(AmazonS3 amazonS3) {
        this.amazonS3 = amazonS3;
    }

    // S3에서 파일을 로컬에 다운로드하는 메서드
    public void downloadFileToLocal(String bucketName, String key) throws IOException {
        S3Object s3object = amazonS3.getObject(bucketName, key);
        InputStream inputStream = s3object.getObjectContent();

        // Spring Boot 애플리케이션 실행 디렉토리 기준으로 static/video 폴더 경로 설정
        Path staticFolderPath = Paths.get("src/main/resources/static/video/");
        if (!Files.exists(staticFolderPath)) {
            Files.createDirectories(staticFolderPath);
        }

        // 파일 저장 경로 설정
        String fileName = new File(key).getName();
        Path downloadFilePath = staticFolderPath.resolve(fileName).toAbsolutePath();

        try (FileOutputStream outputStream = new FileOutputStream(downloadFilePath.toFile())) {
            byte[] readBuffer = new byte[4096];
            int readLen;
            while ((readLen = inputStream.read(readBuffer)) > 0) {
                outputStream.write(readBuffer, 0, readLen);
            }
        }

        inputStream.close();
    }

    // S3에서 파일을 바이트 배열로 다운로드하는 메서드
    public byte[] downloadFileToByteArray(String bucketName, String fileKey) {
        S3Object s3Object = amazonS3.getObject(bucketName, fileKey);
        S3ObjectInputStream objectInputStream = s3Object.getObjectContent();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        try {
            int read;
            byte[] buffer = new byte[4096];
            while ((read = objectInputStream.read(buffer, 0, buffer.length)) != -1) {
                outputStream.write(buffer, 0, read);
            }

            outputStream.flush();
        } catch (IOException e) {
            // handle exception
        } finally {
            try {
                objectInputStream.close();
                outputStream.close();
            } catch (IOException e) {
                // handle exception
            }
        }

        return outputStream.toByteArray();
    }

    // S3 버킷의 파일 목록을 가져오는 메서드
    public List<String> listFiles(String bucketName) {
        List<String> fileNames = new ArrayList<>();
        ObjectListing objectListing = amazonS3.listObjects(bucketName);

        for (S3ObjectSummary os : objectListing.getObjectSummaries()) {
            fileNames.add(os.getKey());
        }

        return fileNames;
    }
}
