package com.example.egudanna.service.email;

import org.springframework.web.multipart.MultipartFile;

public interface EmailService  {
    String sendMail(String to, String subject, String body);
}