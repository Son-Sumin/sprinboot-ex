package com.bitacademy.cocktail.service;

import java.util.Random;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitacademy.cocktail.domain.Mail;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class MailService {

    private JavaMailSender javaMailSender;
    private static final String FROM_ADDRESS = "goldkitty007@gmail.com";
    static StringBuffer key = new StringBuffer();

    public void mailSend(Mail mail){
        try {
            MailHandler mailHandler = new MailHandler(javaMailSender);
            
            // 받는 사람
            mailHandler.setTo(mail.getAddress());
            // 제목
            mailHandler.setSubject("인증메일입니다.");
            Random rnd = new Random();

            for (int i = 0; i < 6; i++) {
                int index = rnd.nextInt(3);
                switch (index) {
                    case 0:
                        key.append(((int) (rnd.nextInt(26)) + 97));
                        break;
                    case 1:
                        key.append(((int) (rnd.nextInt(26)) + 65));
                        break;
                    case 2:
                        key.append((rnd.nextInt(10)));
                        break;
                }
            }
            String htmlContent = "<p> 인증번호:" + key.toString() +"<p>";
            mailHandler.setText(htmlContent, true);
            //mailHandler.setAttach(mail.getFile().getOriginalFilename(), mail.getFile());
            //mailHandler.setInline("sample-img", mail.getFile());
            mailHandler.send();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public boolean answer(String ans){
        return ans.equals(key.toString());
    }
}