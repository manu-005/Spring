package com.xworkz.conference.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/")
@Controller
public class AdminController {

    @GetMapping("adminLoginForm")
    public ModelAndView adminLoginForm(ModelAndView modelAndView){
        modelAndView.setViewName("AdminLoginForm");
        return modelAndView;
    }

    @PostMapping("adminLogin")
    public ModelAndView adminLogin(ModelAndView modelAndView,String email,String password){

        System.out.println("email :"+email);
        System.out.println("password :"+password);
        modelAndView.setViewName("AdminDashBoard");
        return  modelAndView;
    }
}
