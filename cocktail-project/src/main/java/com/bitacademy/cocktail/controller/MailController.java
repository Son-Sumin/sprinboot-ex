//package com.bitacademy.cocktail.controller;
//
//import java.util.Map;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.bitacademy.cocktail.domain.Mail;
//import com.bitacademy.cocktail.service.MailService;
//
//import lombok.RequiredArgsConstructor;
//
//@RestController
//@RequestMapping("/mail")
//@RequiredArgsConstructor
//public class MailController {
//	
//	/* 생성자 주입 */
//    private final MailService mailService;
//
////    @GetMapping("/mail")
////    public String dispMail() {
////        return "mail";
////    }
//
//    @PostMapping("/mail")
//    public void execMail(Mail mail) {
//        mailService.mailSend(mail);
//    }
//
//    @PostMapping("/mail-auth")
//    @ResponseBody
//    public boolean mailAuth(@RequestBody Map<String, String> answer){
//        return mailService.answer(answer.get("answer"));
//    }
//}