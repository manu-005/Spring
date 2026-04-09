package com.xworkz.conference.controller;

import com.xworkz.conference.dto.organizer.ConferenceHosterDTO;
import com.xworkz.conference.dto.organizer.DelegatesEmailDTO;
import com.xworkz.conference.dto.tpoDelegates.InvitedDelegatesDTO;
import com.xworkz.conference.service.conferenceService.ConferenceHosterService;
import com.xworkz.conference.utility.DelegatesMailSending;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.*;

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

      boolean  updatedSentToDelegates = conferenceHosterService.updateSentToDelegates(conferenceId);

      if (updatedSentToDelegates){
          modelAndView.addObject("successMsg", "Invited Successfully..");
      }else{
        modelAndView.addObject("errorMsg", "Please try again after sometimes..");
        }
        modelAndView.setViewName("AllNewEvents"); // JSP page name
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

        if (otp != null) {
            modelAndView.addObject("successMsg", "Success");
        } else {
            modelAndView.addObject("errorMsg", "Error message");
        }
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

            List<DelegatesEmailDTO> allDelegates = conferenceHosterService.getAllDelegates();

            List<ConferenceHosterDTO> tpoDTOList = new ArrayList<>();
            List<Long> conferenceIdList = new ArrayList<>();

            System.out.println("All delegates: " + allDelegates);

            for (DelegatesEmailDTO dto : allDelegates) {

                if (dto.getDelegatesEmail() != null && !dto.getDelegatesEmail().isEmpty()) {

                    String[] emailArray = dto.getDelegatesEmail().split(",");

                    System.out.println("Split Emails: " + Arrays.toString(emailArray));

                    for (String email : emailArray) {

                        if (topEmail.equalsIgnoreCase(email.trim())) {

                            Long conferenceId = dto.getConferenceHoster().getConferenceId();

                            // avoid duplicate conference ids
                            if (!conferenceIdList.contains(conferenceId)) {

                                conferenceIdList.add(conferenceId);

                                ConferenceHosterDTO conferenceDTO =
                                        conferenceHosterService.getAllConferenceHosterById(conferenceId);

                                if (conferenceDTO != null) {
                                    tpoDTOList.add(conferenceDTO);
                                }
                            }
                            break;
                        }
                    }
                }
            }

            System.out.println("Matched Conference IDs: " + conferenceIdList);

            model.addObject("tpoDTOList", tpoDTOList);
            model.addObject("conferenceIdList", conferenceIdList);
            model.addObject("topEmail", topEmail);

            model.setViewName("TPODashBoard");
            return model;
        }

        model.addObject("errorMsg", "Invalid OTP");
        model.setViewName("TPOLoginForm");
        return model;
    }

    @GetMapping("inviteDelegates")
    public ModelAndView inviteDelegates(Long conferenceId, ModelAndView modelAndView, HttpSession session) {

        String sessionEmail = (String) session.getAttribute("topEmail");
        session.setAttribute("conferenceId", conferenceId);
//        modelAndView.addObject("conferenceId", conferenceId + sessionEmail);
        modelAndView.setViewName("DelegateInviteForm");
        return modelAndView;
    }

    @PostMapping("sendDelegateInvitation")
    public ModelAndView sendDelegateInvitation(@Valid InvitedDelegatesDTO delegateDTO, BindingResult bindingResult, HttpSession session, ModelAndView modelAndView) throws MessagingException {

        Long sessionConferenceId = (Long) session.getAttribute("conferenceId");
        String sessionEmail = (String) session.getAttribute("topEmail");

        System.out.println("session conference id :::::::::::" + sessionConferenceId + sessionEmail);
        delegateDTO.setConferenceId(sessionConferenceId);
        delegateDTO.setTpoEmail(sessionEmail);

        System.out.println("____________" + delegateDTO);

        if (bindingResult.hasErrors()) {

            modelAndView.addObject("delegateDTO", delegateDTO);

            modelAndView.addObject("delegateNameError",
                    bindingResult.hasFieldErrors("delegateName") ? bindingResult.getFieldError("delegateName").getDefaultMessage() : "");

            modelAndView.addObject("delegateEmailError",
                    bindingResult.hasFieldErrors("delegateEmail")
                            ? bindingResult.getFieldError("delegateEmail").getDefaultMessage()
                            : "");

            modelAndView.addObject("delegatesMobileNumberError",
                    bindingResult.hasFieldErrors("delegatesMobileNumber")
                            ? bindingResult.getFieldError("delegatesMobileNumber").getDefaultMessage()
                            : "");

            modelAndView.addObject("delegatesOrganizationNameError",
                    bindingResult.hasFieldErrors("delegatesOrganizationName")
                            ? bindingResult.getFieldError("delegatesOrganizationName").getDefaultMessage()
                            : "");

            if (sessionConferenceId == null || sessionEmail == null) {
                modelAndView.addObject("sessionTimeOut", "Your Session time out..!");
            }

            modelAndView.setViewName("DelegateInviteForm");
            return modelAndView;
        }

        delegateDTO.setConferenceId(sessionConferenceId);
        delegateDTO.setTpoEmail(sessionEmail);
        System.out.println("____________" + delegateDTO);

        InvitedDelegatesDTO savedDto = conferenceHosterService.saveInvitedDelegates(delegateDTO);
        System.out.println("saved dto invited  delegates :" + savedDto);
        delegatesMailSending.sendEventDetailsToInvitedDelegates(savedDto.getDelegateEmail(), savedDto.getConferenceId(), savedDto.getDelegateName());

//        System.out.println("saved dtoo :++"+savedDto);

        modelAndView.addObject("successMessage", "Invitation sent successfully");
        modelAndView.setViewName("DelegateInviteForm");
        return modelAndView;
    }

    @GetMapping("viewTPODelegates")
    public ModelAndView viewDelegates(ModelAndView modelAndView,HttpSession session, Long conferenceId){

        String sessionEmail = (String) session.getAttribute("topEmail");
        System.out.println(">>>>>>>>>>>>>session email :"+sessionEmail);

        System.out.println(conferenceId);
       List<InvitedDelegatesDTO> availableDtoList = conferenceHosterService.getAvailableTpoDelegates(sessionEmail,conferenceId);

       if (availableDtoList != null){
           modelAndView.addObject("availableDtoList",availableDtoList);
           modelAndView.setViewName("ViewAvailableDelegates");
       }
        return modelAndView;
    }

    @GetMapping("viewEventDetails")
    public ModelAndView viewEventDetails(ModelAndView modelAndView,String delegatesEmail,Long conferenceId) {

ConferenceHosterDTO viewDetails =conferenceHosterService.getAllConferenceHosterById(conferenceId);

        System.out.println("????????????:"+delegatesEmail+conferenceId);

        modelAndView.addObject("viewDetails",viewDetails);
        modelAndView.addObject("delegatesEmail",delegatesEmail);

        modelAndView.setViewName("ViewDetailOfEvent");
        return modelAndView;

    }

    @PostMapping("delegateResponse")
    public ModelAndView delegateResponse(ModelAndView modelAndView, Long conferenceId, String delegatesEmail, Boolean response) {

        boolean updated = conferenceHosterService.updateDelegateResponse( conferenceId,  delegatesEmail, response);

        if (updated) {

            modelAndView.addObject("successMsg","Thank you for your response.");
        }else{
            modelAndView.addObject("errorMsg","Session time out...!");

        }

        modelAndView.setViewName("ResponseReceiver");
        return modelAndView;
    }
}
