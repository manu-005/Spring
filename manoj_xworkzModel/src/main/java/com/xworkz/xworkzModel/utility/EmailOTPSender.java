package com.xworkz.xworkzModel.utility;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Random;

@Service
public class EmailOTPSender {

    @Autowired
    private JavaMailSender mailSender;

    /* Generate 6-digit random OTP */
    private String generateOtp() {
        int otp = new Random().nextInt(900000) + 100000;
        return String.valueOf(otp);
    }

    /* Generate + Send OTP */
    public String sendOtp(String email) {

        String otp = generateOtp();

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("OTP Verification");
        message.setText("Your OTP is: " + otp + "\nValid for 5 minutes.");

        mailSender.send(message);

        return otp; // return so caller can store (session / DB)
    }

    public void sendMessageToAllStudents(String email, String textMessage) {

        SimpleMailMessage message = new SimpleMailMessage();

        String serverIp = "10.179.218.85"; // 👈 replace with YOUR IPv4
        String link = "http://" + serverIp + ":8080/manoj_xworkzModel/studentResponseForm?studentEmail="
                + URLEncoder.encode(email, StandardCharsets.UTF_8);

        String body = textMessage +
                "\n\nPlease click the link below to respond:\n" + link;
        message.setTo(email);
        message.setSubject("Inform to all Students");
        message.setText(body);

        mailSender.send(message);
    }

}
