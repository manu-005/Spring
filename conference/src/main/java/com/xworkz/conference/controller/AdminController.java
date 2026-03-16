package com.xworkz.conference.controller;

import com.xworkz.conference.dto.organizer.ConferenceHosterDTO;
import com.xworkz.conference.entity.conference.ConferenceHosterEntity;
import com.xworkz.conference.service.conferenceService.ConferenceHosterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/")
@Controller
public class AdminController {

    @Autowired
    ConferenceHosterService conferenceHosterService;

    @GetMapping("adminLoginForm")
    public ModelAndView adminLoginForm(ModelAndView modelAndView) {
        modelAndView.setViewName("AdminLoginForm");
        return modelAndView;
    }

    @PostMapping("adminLogin")
    public ModelAndView adminLogin(ModelAndView modelAndView, String email, String password) {

        System.out.println("email :" + email);
        System.out.println("password :" + password);
        modelAndView.setViewName("AdminDashBoard");
        return modelAndView;
    }

    @GetMapping("getAllHosters")
    public ModelAndView getAllHosters(ModelAndView modelAndView){

        System.out.println("getting all hoster in admin");
        List<ConferenceHosterDTO> allHosters = conferenceHosterService.getAllConferenceHoster();

        modelAndView.addObject("hosters", allHosters);

        for (ConferenceHosterDTO hoster : allHosters) {
            System.out.println("Conference Title in controller : " + hoster.getConferenceTitle());
            System.out.println("Delegates: " + hoster.getDelegates());
        }
        System.out.println("all hosters :"+allHosters);
        modelAndView.setViewName("AllHosters");

        return modelAndView;
    }
}
