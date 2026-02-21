package com.xworkz.conference.controller;

import com.xworkz.conference.dto.organizer.OrganizerRegistrationDTO;
import com.xworkz.conference.service.conferenceService.ConferenceHosterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public ModelAndView saveOrganizerDetails(@Valid OrganizerRegistrationDTO organizerDTO,
                                             BindingResult bindingResult,ModelAndView modelAndView) {

        System.out.println("organizer dto :");
        System.out.println(organizerDTO);

        if (bindingResult.hasErrors()) {

            System.out.println("entered in binding results");

            if (bindingResult.hasFieldErrors("fullName")) {

                System.out.println("error :");
                System.out.println(bindingResult.getFieldError("fullName").getDefaultMessage());
                modelAndView.addObject("fullNameError", bindingResult.getFieldError("fullName").getDefaultMessage());

            }

        }
//        conferenceHosterService.validAndSave(organizerDTO);

        modelAndView.addObject("successMsg", "Your Conference Successfully registered");
        modelAndView.addObject("errorMsg", "Your Conference not registered, please try again..");

        modelAndView.setViewName("index");
        return modelAndView;
    }
}
