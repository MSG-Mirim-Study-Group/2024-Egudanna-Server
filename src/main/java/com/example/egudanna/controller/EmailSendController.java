package com.example.egudanna.controller;

import com.example.egudanna.service.email.EmailService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/api/mails")
public class EmailSendController {
    private EmailService emailService;

    public EmailSendController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/send")
    public String sendMail(@RequestParam(value = "file", name = "file") MultipartFile[] file,
                           @RequestParam("to") String to,
                           @RequestParam("cc") String[] cc,
                           @RequestParam("subject") String subject,
                           @RequestParam("body") String body) {
        return emailService.sendMail(file, to, cc, subject, body);
    }

}