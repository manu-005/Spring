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
import java.util.Optional;

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
            if (bindingResult.hasFieldErrors("fName")) {
                System.out.println("------>" + bindingResult.getFieldError("fName").getDefaultMessage());
                model.addObject("fNameError", bindingResult.getFieldError("fName").getDefaultMessage());
                model.setViewName("SignUp");

            }

            if (bindingResult.hasFieldErrors("lName")){

                model.addObject("lNameError",bindingResult.getFieldError("lName").getDefaultMessage());
                model.setViewName("SignUp");
            }

            if (bindingResult.hasFieldErrors("age")){
                System.out.println(bindingResult.getFieldError("age").getDefaultMessage());
                model.addObject("ageError",bindingResult.getFieldError("age").getDefaultMessage());
                model.setViewName("SignUp");
            }

            if (bindingResult.hasFieldErrors("gender")){
                model.addObject("genderError",bindingResult.getFieldError("gender").getDefaultMessage());
                model.setViewName("SignUp");
            }

            if (bindingResult.hasFieldErrors("email")){
                model.addObject("emailError",bindingResult.getFieldError("email").getDefaultMessage());
                model.setViewName("SignUp");
            }

            if (bindingResult.hasFieldErrors("mobile")){
                model.addObject("mobileError",bindingResult.getFieldError("mobile").getDefaultMessage());
                model.setViewName("SignUp");
            }

            if (bindingResult.hasFieldErrors("password")){
                model.addObject("passwordError",bindingResult.getFieldError("password").getDefaultMessage());
                model.setViewName("SignUp");
            }

            if (!dto.getPassword().equals(dto.getConfirmPassword())){
                model.addObject("confirmPasswordError","password and confirm password must be match");
                model.setViewName("SignUp");
            }

            model.setViewName("SignUp");
            return model;
        } else {
            //save
            System.out.println("calling service--");
            boolean saved =  service.validAndSave(dto);

            System.out.println("Saved from service :"+saved);
        if (saved){
            model.addObject("success","Successfully Sign Up..!");
        }else{
            model.addObject("error","Try again Later ..!");
        }
            model.setViewName("SignUp");

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
        System.out.println("controller started");

        if (email == null || email.trim().isEmpty()) {
            model.addAttribute("error", "Please enter valid email");
            return "SignIn";
        }
         if (service.signIn(email, password)) {

             model.addAttribute("success", "Valid enter successful ");

             return "SignIn";
         }
         else {
            UserDto dto = service.findByEmail(email);

            int attempts =dto.getFailedAttempts();
             System.out.println("Attempts:"+attempts);

            int updatedAttempts= attempts + 1;
             System.out.println("updated attempts"+updatedAttempts);

            dto.setFailedAttempts(updatedAttempts);
             System.out.println("after set updated attempts"+dto);

//            service.updateFailedAttempts(dto);

             model.addAttribute("error", "Please enter valid email"+attempts);
             return "SignIn";
         }
    }

        //find exist
//        UserDto user = service.findByEmail(email);

//        if (user != null) {
//            System.out.println("exist");
//            System.out.println("controller dto by mail " + user);
//            model.addAttribute("success", "valid Email or Password");
//            return "SignIn";
//        }
//       else{
//            System.out.println("not exist");
//            model.addAttribute("error", "Invalid Email or Password");
//            return "SignIn";
//        }

//        // password wrong
//        if (!user.get().getPassword().equals(password)) {
//
//            System.out.println("attempts" + user.get().getFailedAttempts());
//
////            int attempts = service.getFailedAttemptsByDB(user.getId());
//            int attempts = user.get().getFailedAttempts();
//            attempts += 1;
//
//            user.get().setFailedAttempts(attempts);
//
//            System.out.println("after setting attempts :" + user);
//            System.out.println("Attempts in after +1  controller :"+attempts);
//
//            UserDto updatedDto = service.updateFailedAttempts(user);
//
//            model.addAttribute("error", "Invalid Email or Password");
//
//            // AFTER 3 WRONG ATTEMPTS
//            if (attempts >= 3) {
//                model.addAttribute("showForgot", true);
//            }
//
//            return "SignIn";
//        }
//
//        // SUCCESS LOGIN
//        user.setFailedAttempts(0);
//        service.updateFailedAttempts(user);
//
//
//            return "Home";




    @GetMapping("logOut")
    public String logOut() {
        return "index";
    }


}
