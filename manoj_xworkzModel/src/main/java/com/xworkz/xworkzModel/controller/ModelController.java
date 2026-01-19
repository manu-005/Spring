package com.xworkz.xworkzModel.controller;

import com.xworkz.xworkzModel.dto.UserDto;
import com.xworkz.xworkzModel.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@Controller
public class ModelController {

    @Autowired
    ModelService service;

    public ModelController(){
        System.out.println("controller object..");
    }

    @GetMapping("signUp")
    public String signUp(){
        return "SignUp";
    }

    @GetMapping("signIn")
    public String signIn(){
        return "SignIn";
    }

    @PostMapping("signUpUser")
    public String signUpUser(UserDto dto, Model model){
        System.out.println(dto);

      boolean saved =  service.validAndSave(dto);
        if (saved){
            model.addAttribute("success","Successfully Sign Up..!");
        }else{
            model.addAttribute("error","Try again Later ..!");
        }
        return "SignUp";
    }
@Validated
    @PostMapping("signInUser")
    public String signInUser(String email, String password, Model model) {

        boolean exists = service.signIn(email, password);
        System.out.println("existss :"+exists);
        if (exists) {
            return "Home";   // Home.jsp
        } else {
            model.addAttribute("error", "Invalid Email or Password");
            return "SignIn";
        }
    }

    @GetMapping("logOut")
    public String logOut(){
        return "index";
    }


}
