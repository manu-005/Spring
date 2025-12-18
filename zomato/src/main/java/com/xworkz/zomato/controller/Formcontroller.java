package com.xworkz.zomato.controller;


import com.xworkz.zomato.dto.CheckExistEmailDTO;
import com.xworkz.zomato.dto.RestaurantDTO;
import com.xworkz.zomato.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/")
public class Formcontroller {

    public Formcontroller() {
        System.out.println("form controller object created");
    }

    @Autowired
    FormService formService;

    @PostMapping("/addMyStore")
    public String validAndSave(RestaurantDTO restaurantDTO) {
        System.out.println(restaurantDTO);

        boolean validAndSave = formService.valid(restaurantDTO);

        if (validAndSave) {
            System.out.println("valid and save");
            return "success.jsp";
        } else {
            System.out.println("not valid and save");
            return "error.jsp";
        }
    }

    @GetMapping("/checkEmail")
    public String checkExist(CheckExistEmailDTO checkExistEmailDTO) {

        boolean exist = formService.checkExit(checkExistEmailDTO);
        System.out.println(checkExistEmailDTO);
        if (exist) {
            return "Exist.jsp";
        } else {
            return "NotExist.jsp";
        }
    }
}
