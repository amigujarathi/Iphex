package com.pharmerz.iphex.api.server.service;

/**
 * Created by ankurpathak on 03-02-2016.
 */
public interface IMailService {




    void sendSimpleMail(String email, String subject, String message);



    void sendHtmlMail(String email, String subject, String message);





}
