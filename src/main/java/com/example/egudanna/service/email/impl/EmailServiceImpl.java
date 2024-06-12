package com.example.egudanna.service.email.impl;

import com.example.egudanna.service.email.EmailService;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.MailSendException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class EmailServiceImpl implements EmailService {

    @Value("${spring.mail.username}")
    private String fromEmail;

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public String sendMail(MultipartFile[] file, String to, String subject, String body) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(fromEmail);
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(body);

            for (MultipartFile multipartFile : file) {
                mimeMessageHelper.addAttachment(multipartFile.getOriginalFilename(), new ByteArrayResource(multipartFile.getBytes()));
            }
            javaMailSender.send(mimeMessage);
            return "mail send";

        } catch (MailSendException e) {
            // Detailed logging for MailSendException
            return "Failed to send email: " + e.getMessage();
        } catch (Exception e) {
            // General exception handling
            throw new RuntimeException("Email sending failed", e);
        }
    }
}