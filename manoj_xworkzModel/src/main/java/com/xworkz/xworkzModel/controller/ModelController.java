package com.xworkz.xworkzModel.controller;

import com.xworkz.xworkzModel.dto.UserDto;
import com.xworkz.xworkzModel.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/")
@Controller
public class ModelController {

    @Autowired
    ModelService service;

    public ModelController() {
        System.out.println("controller object..");
    }

    @GetMapping("signUp")
    public String signUp() {
        return "SignUp";
    }

    @GetMapping("signIn")
    public String signIn() {
        return "SignIn";
    }

    @PostMapping("signUpUser")
    public ModelAndView signUpUser(@Valid UserDto dto, BindingResult bindingResult, ModelAndView model) {
        System.out.println(dto);
        if (bindingResult.hasErrors()) {
//            List<ObjectError> allErrors = bindingResult.getAllErrors();

//            List<String> errors = new ArrayList<>();
//            for (ObjectError error : bindingResult.getFieldErrors()) {
//                System.out.println(error.getDefaultMessage());
//                String defaultMessage = error.getDefaultMessage();
//                errors.add(defaultMessage);
////               model.setViewName("",allErrors.add(error.getDefaultMessage());
//            }
//            model.addObject("errors", errors);
//            model.addObject("errors",allErrors);
            if(bindingResult.hasFieldErrors("fName")){
                System.out.println("------>" + bindingResult.getFieldError("fName").getDefaultMessage());

              model.addObject("fNameError",bindingResult.getFieldError("fName").getDefaultMessage());
                model.setViewName("SignUp");

            }

            model.setViewName("SignUp");
            return model;
        } else {
            //save
            model.setViewName("SignIn");

            return model;

        }

//      boolean saved =  service.validAndSave(dto);
//        if (saved){
//            model.addAttribute("success","Successfully Sign Up..!");
//        }else{
//            model.addAttribute("error","Try again Later ..!");
//        }
//        return "Home";
    }

    @PostMapping("signInUser")
    public String signInUser(String email, String password, Model model) {

        boolean exists = service.signIn(email, password);
        System.out.println("existss :" + exists);
        if (exists) {
            return "Home";   // Home.jsp
        } else {
            model.addAttribute("error", "Invalid Email or Password");
            return "SignIn";
        }
    }

    @GetMapping("logOut")
    public String logOut() {
        return "index";
    }


}
