package com.xworkz.conference.controller;

import com.xworkz.conference.dto.organizer.OrganizerRegistrationDTO;
import com.xworkz.conference.service.conferenceService.ConferenceHosterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class ConferenceHosterController {

    @Autowired
    ConferenceHosterService conferenceHosterService;

    public ConferenceHosterController(){
        System.out.println("conference hoster controller object created ..");
    }

    @PostMapping("organizerDetails")
    public ModelAndView saveOrganizerDetails( ModelAndView modelAndView, OrganizerRegistrationDTO organizerDTO){

        System.out.println("organizer dto :");
        System.out.println(organizerDTO);

        conferenceHosterService.validAndSave(organizerDTO);

        modelAndView.addObject("successMsg","Your Conference Successfully registered");
        modelAndView.addObject("errorMsg","Your Conference not registered, please try again..");

        modelAndView.setViewName("index.jsp");
        return  modelAndView;
    }
}
