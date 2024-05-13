//package com.example.egudanna.service;
//
//import com.example.egudanna.domain.MailStructure;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.stereotype.Service;
//
//@Service
//public class MailService {
//    // mail을 보내는 메서드
//    @Autowired
//    private JavaMailSender mailSender;
//
//    @Value("${spring.mail.username}")
//    private String fromMail;
//
//    // 간단한 메일 메시지 생성
//    public void sendMail(String mail, MailStructure mailStructure) {
//        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();// mail 메시지의 객체
//        simpleMailMessage.setFrom(fromMail);// 메일을 전송하는 사람
//        simpleMailMessage.setSubject(mailStructure.getSubject());// 요청 본문에 있는 제목으로 제목을 설정
//        simpleMailMessage.setText(mailStructure.getMessage());// 메일 본문
//        simpleMailMessage.setTo(mail);// 누구에게 메일을 보낼 것인가
//
//        mailSender.send(simpleMailMessage);
//
//    }
//}
