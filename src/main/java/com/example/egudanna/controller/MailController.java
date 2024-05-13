//package com.example.egudanna.controller;
//
//import com.example.egudanna.domain.MailStructure;
//import com.example.egudanna.service.MailService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/mail")
//public class MailController {
//
//    @Autowired
//    private MailService mailService;
//
//    @PostMapping("/{mail}")
//    public String sendMail(@PathVariable("mail") String mail, @RequestBody MailStructure mailStructure) {
//        mailService.sendMail(mail, mailStructure);
//        return "Successfully sent the mail !!";
//    }
//}
