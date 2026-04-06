package com.xworkz.conference.utility;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Service
public class DelegatesMailSending {

    @Autowired
    private JavaMailSender mailSender;
    
    public void sendEventDetailsToDelegates(String email, Long conferenceId) {

        SimpleMailMessage message = new SimpleMailMessage();

        // Use ngrok public URL (not local IP)
        String baseUrl = "https://mesoappendiceal-postillioned-bently.ngrok-free.dev";

        String link = baseUrl + "/conference/tpoLogIn?tpoEmail="+ URLEncoder.encode(email, StandardCharsets.UTF_8)+"&conferenceId="+conferenceId;

        String body = "textMessage" +
                "\n\nPlease click the link below to respond:\n" + link;

        message.setTo(email);  // mails...
        message.setSubject("");  //sub
        message.setText(body);

        mailSender.send(message);
    }
}
