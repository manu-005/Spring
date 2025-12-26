package com.xworkz.passport.controller;


import com.xworkz.passport.dto.PassPortRegisterDTO;
import com.xworkz.passport.service.PassPortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Controller
@RequestMapping("/")
public class PassPortController {

    @Autowired
    PassPortService service;

    public PassPortController(){
        System.out.println("pass port controller object created");
    }
   @Bean
   public ViewResolver viewResolver(){
        InternalResourceViewResolver view = new InternalResourceViewResolver();
       view.setPrefix("/");
        view.setSuffix(".jsp");
        return view;
   }

    @PostMapping("registerUser")
public String registerUser(PassPortRegisterDTO passPortRegisterDTO, Model model){

        System.out.println(passPortRegisterDTO);

     boolean valid =   service.validSave(passPortRegisterDTO);

     if (valid){
         model.addAttribute("success","Successfully register..!");
     }else{
         model.addAttribute("error","Try again some times ..!");

     }
        return "index";
    }
}
