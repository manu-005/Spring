package com.xworkz.conference.controller;

import com.xworkz.conference.dto.organizer.ConferenceHosterDTO;
import com.xworkz.conference.service.conferenceService.ConferenceHosterService;
import com.xworkz.conference.utility.DelegatesMailSending;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;
import java.util.List;

@RequestMapping("/")
@Controller
public class TPOController {

    @Autowired
    DelegatesMailSending delegatesMailSending;

    @Autowired
    ConferenceHosterService conferenceHosterService;

    @PostMapping("shareConference")
    public ModelAndView shareConference(Long conferenceId, String emails, ModelAndView modelAndView) throws MessagingException {

        List<ConferenceHosterDTO> allEvents = conferenceHosterService.getAllConferenceHoster();
        modelAndView.addObject("allEvents", allEvents);

        System.out.println("conference id in share event : " + conferenceId);

        System.out.println("emails in share event : " + emails);

        String[] emailsArray = emails.split(",");

        for (String e : emailsArray) {

            delegatesMailSending.sendEventDetailsToDelegates(e, conferenceId);
        }


        modelAndView.addObject("successMsg", "Invited Successfully..");

        modelAndView.addObject("errorMsg", "Please try again after sometimes..");
        modelAndView.setViewName("AllEventsDetails"); // JSP page name
        return modelAndView;
    }

    @GetMapping("tpoLogIn")
    public ModelAndView tpoLogIn(ModelAndView modelAndView, String tpoEmail, Long conferenceId) {

        System.out.println("tpo email :===" + tpoEmail);
        System.out.println("conference d :+++==" + conferenceId);

        modelAndView.addObject("topEmail", tpoEmail);
        modelAndView.addObject("conferenceId", conferenceId);
        modelAndView.setViewName("TPOLoginForm");
        return modelAndView;
    }

    @PostMapping("getOtp")
    public ModelAndView getOtp(String topEmail, ModelAndView modelAndView, HttpSession session) {

        System.out.println("email in get Otp :" + topEmail);

        // generate and send otp
        String otp = delegatesMailSending.sendOtp(topEmail);

        session.setAttribute("otpSent", otp);
        session.setAttribute("topEmail", topEmail);

        modelAndView.addObject("successMsg", "Success");
        modelAndView.addObject("errorMsg", "Error message");

        modelAndView.setViewName("TPOLoginForm");
        return modelAndView;
    }

    @PostMapping("verifyOTP")
    public ModelAndView verifyOTP(String enteredOtp,
                            String topEmail,
                            HttpSession session,
                            ModelAndView model) {

        String sentOtp = (String) session.getAttribute("otpSent");
        String sessionEmail = (String) session.getAttribute("topEmail");

        if (sentOtp != null
                && sessionEmail != null
                && sessionEmail.equals(topEmail)
                && sentOtp.equals(enteredOtp)) {

            model.addObject("successMsg", "OTP Verified Successfully");
            model.setViewName("TPODashBoard");

            return model;
        }

        model.addObject("errorMsg", "Invalid OTP");
        model.setViewName("TPOLoginForm");

        return model;
    }

}
