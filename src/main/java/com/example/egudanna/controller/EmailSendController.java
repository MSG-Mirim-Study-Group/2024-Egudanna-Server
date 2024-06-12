package com.example.egudanna.controller;

import com.example.egudanna.domain.Challenge;
import com.example.egudanna.repository.ChallengeRepository;
import com.example.egudanna.service.email.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/api/mails")
public class EmailSendController {
    private final EmailService emailService;

    @Autowired
    public EmailSendController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/send")
    public String sendMail(@RequestParam(value = "file", name = "file") MultipartFile[] file,
                           @RequestParam("to") String to,
                           @RequestParam("subject") String subject,
                           @RequestParam("body") String body) {



        return emailService.sendMail(file, to, subject, body);
    }

}