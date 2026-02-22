package com.xworkz.conference.controller;

import com.xworkz.conference.dto.organizer.OrganizerRegistrationDTO;
import com.xworkz.conference.service.conferenceService.ConferenceHosterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class ConferenceHosterController {

    @Autowired
    ConferenceHosterService conferenceHosterService;

    public ConferenceHosterController() {
        System.out.println("conference hoster controller object created ..");
    }

    @PostMapping("organizerDetails")
    public ModelAndView saveOrganizerDetails(@Valid OrganizerRegistrationDTO organizerDTO,BindingResult bindingResult,ModelAndView modelAndView) {

        System.out.println("organizer dto :");
        System.out.println(organizerDTO);

        MultipartFile conferenceBanner = organizerDTO.getConferenceBanner();
//        MultipartFile promoVideo = organizerDTO.getPromoVideo();

        System.out.println("banner :"+conferenceBanner);
        if (bindingResult.hasErrors()) {

            if (conferenceBanner == null || conferenceBanner.isEmpty()){
                System.out.println("banner");
                modelAndView.addObject("bannerError","please upload banner");
            }

//            if (promoVideo == null || promoVideo.isEmpty()){
//
//                System.out.println("promo video");
//                modelAndView.addObject("promoVideoError","please upload promo video");
//            }

            System.out.println("entered in binding results");

            if (bindingResult.hasFieldErrors("fullName")) {

                System.out.println("name error :");
                System.out.println(bindingResult.getFieldError("fullName").getDefaultMessage());
                modelAndView.addObject("fullNameError", bindingResult.getFieldError("fullName").getDefaultMessage());
            }
            if (bindingResult.hasFieldErrors("officialEmail")){

                modelAndView.addObject("emailError",bindingResult.getFieldError("officialEmail").getDefaultMessage());
            }
            if (bindingResult.hasFieldErrors("organizationName")){

                modelAndView.addObject("organizationNameError",bindingResult.getFieldError("organizationName").getDefaultMessage());
            }
            if (bindingResult.hasFieldErrors("conferenceTitle")){

                modelAndView.addObject("conferenceTitleError",bindingResult.getFieldError("conferenceTitle").getDefaultMessage());
            }
            if (bindingResult.hasFieldErrors("conferenceDescription")){

                modelAndView.addObject("conferenceDescriptionError",bindingResult.getFieldError("conferenceDescription").getDefaultMessage());
            }
            if (bindingResult.hasFieldErrors("date")){

                modelAndView.addObject("dateError",bindingResult.getFieldError("date").getDefaultMessage());
            }
            if (bindingResult.hasFieldErrors("time")){

                modelAndView.addObject("timeError",bindingResult.getFieldError("time").getDefaultMessage());
            }
            if (bindingResult.hasFieldErrors("mode")){

                modelAndView.addObject("modeError",bindingResult.getFieldError("mode").getDefaultMessage());
            }
            if (bindingResult.hasFieldErrors("venueOrMeetingLink")){

                modelAndView.addObject("venueOrMeetingLinkError",bindingResult.getFieldError("venueOrMeetingLink").getDefaultMessage());
            }
        }
//        conferenceHosterService.validAndSave(organizerDTO);
else {
            System.out.println("else part");
            modelAndView.addObject("successMsg", "Your Conference Successfully registered");
            modelAndView.addObject("errorMsg", "Your Conference not registered, please try again..");
        }
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
