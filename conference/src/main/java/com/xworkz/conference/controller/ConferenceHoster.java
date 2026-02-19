package com.xworkz.conference.controller;

import com.xworkz.conference.dto.organizer.OrganizerRegistrationDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class ConferenceHoster {

    public ConferenceHoster(){
        System.out.println("conference hoster controller object created ..");
    }

    @PostMapping
    public ModelAndView saveOrganizerDetails(ModelAndView modelAndView, OrganizerRegistrationDTO organizerDTO){

        System.out.println("organizer dto :");
        System.out.println(organizerDTO);

        modelAndView.addObject("successMsg","Your Conference Successfully registered");
        modelAndView.setViewName("index");
        return  modelAndView;
    }
}
