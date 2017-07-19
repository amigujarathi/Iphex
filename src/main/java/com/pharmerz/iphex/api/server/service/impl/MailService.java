package com.pharmerz.iphex.api.server.service.impl;

import com.pharmerz.iphex.api.server.service.IMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;


/**
 * Created by ankurpathak on 03-02-2016.
 */

@Component
public class MailService implements IMailService {

    @Autowired
    private JavaMailSender mailSender;





    @Override
    @Async
    public void sendSimpleMail(String email, String subject, String message){


        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("support@pharmerz.in");
        simpleMailMessage.setTo(email);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(message);
        mailSender.send(simpleMailMessage);
    }


    @Override
    @Async
    public void sendHtmlMail(String email, String subject, String html) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        try{
            MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");
            message.setSubject(subject);
            message.setFrom("support@pharmerz.in");
            message.setTo(email);
            message.setText(html, true);
            mailSender.send(mimeMessage);
        }catch (Exception ex){

        }


    }





}
