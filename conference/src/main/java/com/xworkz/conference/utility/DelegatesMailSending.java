package com.xworkz.conference.utility;

import com.xworkz.conference.dto.organizer.ConferenceHosterDTO;
import com.xworkz.conference.service.conferenceService.ConferenceHosterService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Random;

@Service
public class DelegatesMailSending {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    ConferenceHosterService conferenceHosterService;
    
//    public void sendEventDetailsToDelegates1(String email) {
//
//        SimpleMailMessage message = new SimpleMailMessage();
//
//        // Use ngrok public URL (not local IP)
//        String baseUrl = "https://mesoappendiceal-postillioned-bently.ngrok-free.dev";
//
////        String link = baseUrl + "/conference/tpoLogIn?tpoEmail="+ URLEncoder.encode(email, StandardCharsets.UTF_8)+"&conferenceId="+conferenceId;
//
//        String body = "textMessage" +
//                "\n\nPlease click the link below to respond:\n" + link;
//
//        message.setTo(email);  // mails...
//        message.setSubject("");  //sub
//        message.setText(body);
//
//        mailSender.send(message);
//    }

    public void sendEventDetailsToDelegates(String email,Long conferenceId) throws MessagingException {

        String baseUrl = "https://mesoappendiceal-postillioned-bently.ngrok-free.dev";

        ConferenceHosterDTO dto= conferenceHosterService.getAllConferenceHosterById(conferenceId);
        String link = baseUrl
                + "/conference/tpoLogIn?tpoEmail="
                + URLEncoder.encode(email, StandardCharsets.UTF_8)
                + "&conferenceId="
                + conferenceId;

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

        helper.setTo(email);
        helper.setSubject("Conference Invitation - " + dto.getConferenceTitle());

        FileSystemResource poster = new FileSystemResource(new File(dto.getBannerPath()));

        String html =
                "<div style='font-family:Arial,sans-serif;background:#f4f6fb;padding:30px;'>" +
                        "<div style='max-width:650px;margin:auto;background:#ffffff;border-radius:18px;" +
                        "overflow:hidden;box-shadow:0 8px 30px rgba(0,0,0,0.08);'>" +

                        "<div style='background:#0059ff;color:white;padding:25px;text-align:center;'>" +
                        "<h2 style='margin:0;'>ConferoNexus</h2>" +
                        "<p style='margin:8px 0 0;'>Conference Invitation</p>" +
                        "</div>" +

                        "<div style='padding:30px;'>" +
                        "<p style='font-size:16px;'>Hello,</p>" +

                        "<p style='font-size:15px;color:#444;'>You are invited to attend the following conference:</p>" +

                        "<div style='background:#f8f9ff;border:1px solid #dbe4ff;border-radius:14px;padding:20px;margin:20px 0;'>" +
                        "<h3 style='margin-top:0;color:#0059ff;'>" + dto.getConferenceTitle() + "</h3>" +
                        "<p style='color:#555;line-height:1.6;'>" +  dto.getConferenceDescription() + "</p>" +

                        "<table style='width:100%;font-size:14px;color:#333;'>" +
                        "<tr><td><b>Date:</b></td><td>" + dto.getDate() + "</td></tr>" +
                        "<tr><td><b>Time:</b></td><td>" + dto.getTime() + "</td></tr>" +
                        "<tr><td><b>Venue:</b></td><td>" + dto.getVenueOrMeetingLink() + "</td></tr>" +
                        "</table>" +

                        "<div style='text-align:center;margin:25px 0;'>" +
                        "<img src='cid:conferencePoster' style='max-width:100%; border-radius:12px;' />" +
                        "</div>"+

                        "<div style='text-align:center;margin-top:35px;'>" +
                        "<a href='" + link + "' style='background:#0059ff;color:white;text-decoration:none;" +
                        "padding:14px 30px;border-radius:10px;font-size:16px;font-weight:bold;display:inline-block;'>" +
                        "Click Here to Login for TPO</a>" +
                        "</div>" +

                        "</div></div></div>";

        // Add poster image attachment or inline image

        helper.setText(html, true);   // first
        helper.addInline("conferencePoster", poster);   // second

        // Option 1: show poster inside the email body

        // Add this inside the HTML before the login button:
        // <div style='text-align:center;margin:25px 0;'>
        //     <img src='cid:conferencePoster'
        //          style='max-width:100%;border-radius:12px;'>
        // </div>

        // Option 2: also attach the poster file in the mail
        helper.addAttachment("ConferencePoster.jpg", poster);

        mailSender.send(message);

    }

    public String sendOtp(String email) {

        String otp = generateOtp();

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("OTP Verification");
        message.setText("Your OTP is: " + otp + "\nValid for 5 minutes.");

        mailSender.send(message);

        return otp; // return so caller can store (session / DB)
    }

    /* Generate 6-digit random OTP */
    private String generateOtp() {
        int otp = new Random().nextInt(900000) + 100000;
        return String.valueOf(otp);
    }

    public void sendEventDetailsToInvitedDelegates(String delegatesEmail,
                                                   Long conferenceId,
                                                   String delegatesName) throws MessagingException {

        String baseUrl = "https://mesoappendiceal-postillioned-bently.ngrok-free.dev";

        ConferenceHosterDTO dto =
                conferenceHosterService.getAllConferenceHosterById(conferenceId);

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

        helper.setTo(delegatesEmail);
        helper.setSubject("Conference Invitation - " + dto.getConferenceTitle());

        FileSystemResource poster =
                new FileSystemResource(new File(dto.getBannerPath()));

        String responseLink = baseUrl + "/conference/viewEventDetails";

        String html =
                "<div style='font-family:Arial,sans-serif;background:#f4f6fb;padding:30px;'>" +
                        "<div style='max-width:650px;margin:auto;background:#ffffff;border-radius:18px;" +
                        "overflow:hidden;box-shadow:0 8px 30px rgba(0,0,0,0.08);'>" +

                        "<div style='background:#0059ff;color:white;padding:25px;text-align:center;'>" +
                        "<h2 style='margin:0;'>ConferoNexus</h2>" +
                        "<p style='margin:8px 0 0;'>Conference Invitation</p>" +
                        "</div>" +

                        "<div style='padding:30px;'>" +

                        "<p style='font-size:16px;'>Hello " + delegatesName + ",</p>" +

                        "<p style='font-size:15px;color:#444;'>You are invited to attend the following conference:</p>" +

                        "<div style='background:#f8f9ff;border:1px solid #dbe4ff;border-radius:14px;padding:20px;margin:20px 0;'>" +
                        "<h3 style='margin-top:0;color:#0059ff;'>" + dto.getConferenceTitle() + "</h3>" +
                        "<p style='color:#555;line-height:1.6;'>" + dto.getConferenceDescription() + "</p>" +

                        "<table style='width:100%;font-size:14px;color:#333;'>" +
                        "<tr><td><b>Date:</b></td><td>" + dto.getDate() + "</td></tr>" +
                        "<tr><td><b>Time:</b></td><td>" + dto.getTime() + "</td></tr>" +
                        "<tr><td><b>Venue:</b></td><td>" + dto.getVenueOrMeetingLink() + "</td></tr>" +
                        "</table>" +
                        "</div>" +

                        "<div style='text-align:center;margin:25px 0;'>" +
                        "<img src='cid:conferencePoster' style='max-width:100%;border-radius:12px;'/>" +
                        "</div>" +

                        "<p style='font-size:16px;font-weight:bold;color:#333;text-align:center;margin-top:25px;'>" +
                        "Will you attend this event?" +
                        "</p>" +

                        "<form action='" + responseLink + "' method='get' style='text-align:center;margin-top:20px;'>" +

                        "<input type='hidden' name='conferenceId' value='" + conferenceId + "'>" +
                        "<input type='hidden' name='delegatesEmail' value='" + delegatesEmail + "'>" +

                        "<button type='submit' " +
                        "style='background:#0059ff;color:white;border:none;padding:14px 30px;" +
                        "border-radius:10px;font-size:16px;font-weight:bold;cursor:pointer;'>" +
                        "View Details" +
                        "</button>" +

                        "</form>" +

                        "</div></div></div>";

        helper.setText(html, true);
        helper.addInline("conferencePoster", poster);
        helper.addAttachment("ConferencePoster.jpg", poster);

        mailSender.send(message);
    }
}
