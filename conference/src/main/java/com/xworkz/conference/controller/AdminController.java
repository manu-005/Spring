package com.xworkz.conference.controller;

import com.xworkz.conference.dto.organizer.ConferenceHosterDTO;
import com.xworkz.conference.dto.organizer.DelegatesEmailDTO;
import com.xworkz.conference.entity.conference.ConferenceHosterEntity;
import com.xworkz.conference.service.conferenceService.ConferenceHosterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

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
    public ModelAndView getAllHosters(ModelAndView modelAndView) {

        System.out.println("getting all hoster in admin");
        List<ConferenceHosterDTO> allHosters = conferenceHosterService.getAllConferenceHoster();

        modelAndView.addObject("hosters", allHosters);

        for (ConferenceHosterDTO hoster : allHosters) {
            System.out.println("Conference Title in controller : " + hoster.getConferenceTitle());
            System.out.println("Delegates: " + hoster.getDelegates());

        }
        System.out.println("all hosters :" + allHosters);
        modelAndView.setViewName("AllHosters");

        return modelAndView;
    }

    @GetMapping("getAllDelegates")
    public ModelAndView getAllDelegates(ModelAndView modelAndView) {
        System.out.println("entered  in All delegates");
        modelAndView.setViewName("AllDelegates");
        return modelAndView;
    }

    @GetMapping("filterDelegates")
    public ModelAndView filterDelegates(ModelAndView modelAndView, String type) {

        List<DelegatesEmailDTO> allDelegates = conferenceHosterService.getAllDelegates();

        List<DelegatesEmailDTO> sameDelegates = new ArrayList<>();
        Set<String> emailList = new HashSet<>();

        System.out.println("all delegates in controller :" + allDelegates);

        for (DelegatesEmailDTO dto : allDelegates) {

            if (type != null && type.equals(dto.getTargetDelegates())) {

                String[] emailArray = dto.getDelegatesEmail().split(",");

                System.out.println("all emails after split :" + Arrays.toString(emailArray));

                for (String email : emailArray) {
                    emailList.add(email.trim());
                }

                sameDelegates.add(dto);
            }
        }

        System.out.println("after split email ids :" + emailList);

        modelAndView.addObject("sameDelegatesList", sameDelegates);
        modelAndView.addObject("emailList", emailList);

        modelAndView.setViewName("AllDelegates");

        return modelAndView;
    }

    @GetMapping("getAllEvents")
    public ModelAndView getAllEvents(ModelAndView modelAndView){

        List<ConferenceHosterDTO> allEvents = conferenceHosterService.getAllConferenceHoster();

        modelAndView.addObject("allEvents",allEvents);
        modelAndView.setViewName("AllEventsDetails");
        return modelAndView;
    }

}