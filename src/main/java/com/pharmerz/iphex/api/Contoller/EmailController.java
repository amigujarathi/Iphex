package com.pharmerz.iphex.api.Contoller;

import com.pharmerz.iphex.api.Application.EmailSend;
import com.pharmerz.iphex.api.server.domain.model.Email;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by i5 on 4/15/2017.
 */

@RestController
@RequestMapping("/api/v1/")
public class EmailController {


    @PostMapping(value = "/sendemail",consumes = MediaType.APPLICATION_JSON_VALUE ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Email> createEmail(@RequestBody Email email){

        String to=email.getTo();
        String subject=email.getSubject();
        String body=email.getBody();

        EmailSend emailSend=new EmailSend();
        emailSend.SendMail(to,subject,body);



        return new ResponseEntity<Email>(email,HttpStatus.OK);

    }

}
