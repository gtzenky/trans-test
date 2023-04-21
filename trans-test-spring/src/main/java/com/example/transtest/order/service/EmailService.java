package com.example.transtest.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    private String sender = "sender@gmail.com";

    public void sendMailNotification(String email, String title, String content) {

        try {
            SimpleMailMessage message = new SimpleMailMessage();

            message.setFrom(sender);
            message.setTo(email);
            message.setSubject(title);
            message.setText(content);

            mailSender.send(message);
        } catch (Exception ex) {

        }
    }
}
