package com.xworkz.zomato.controller;


import com.xworkz.zomato.dto.CheckExistEmailDTO;
import com.xworkz.zomato.dto.RestaurantDTO;
import com.xworkz.zomato.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

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
            return "success";
        } else {
            System.out.println("not valid and save");
            return "error";
        }
    }

    @GetMapping("/checkEmail")
    public String checkExist(CheckExistEmailDTO checkExistEmailDTO) {

        boolean exist = formService.checkExit(checkExistEmailDTO);
        System.out.println(checkExistEmailDTO);
        if (exist) {
            return "Exist";
        } else {
            return "NotExist";
        }
    }

    @GetMapping("searchByName")
    public String searchByRestuarantName(@RequestParam("searchByRestaurantName") String searchByRestaurantName, Model model) {

        System.out.println(searchByRestaurantName);

        Optional<RestaurantDTO> dto = formService.searchByName(searchByRestaurantName);

        if (dto.isPresent()) {
            model.addAttribute("dto", dto.get());
        } else {
            model.addAttribute("error", "Not found");
        }

        System.out.println(dto);
        return "SearchByRestaurantName";
    }

    @GetMapping("searchByNameAndLoc")
    public String searchByNameAndLoc(String searchByRestaurantName, String searchByRestaurantLocation, Model model) {

        Optional<RestaurantDTO> dto = formService.searchByNameAndLoc(searchByRestaurantName, searchByRestaurantLocation);

        if (dto.isPresent()) {
            model.addAttribute("dto", dto.get());
        } else {
            model.addAttribute("error", "Not found");
        }


        return "SearchByRestaurantNameAndLocation";
    }
   @GetMapping("edit/{anything}")
    public String getRestaurantByNameEdit(@PathVariable("anything") String name , Model model){
    System.out.println(name);

    Optional<RestaurantDTO> dto = formService.searchByName(name);

    if (dto.isPresent()) {
        System.out.println("Dto is about to rendered to UI");
      //  model.addAttribute("res", dto.get());
        model.addAttribute("res", dto.get());
        return "UpdateByName";

    } else {
        model.addAttribute("error", "Try again later!!");
        return "UpdateByName";
    }
}

@PostMapping("/update")
    public String updateByName( RestaurantDTO restaurantDTO , Model model){

      boolean updated =  formService.updateById(restaurantDTO);

    if (updated){
        model.addAttribute("success","Data Updated Successfully..");
    }else{
        model.addAttribute("error","Try again later..");

    }
    return "UpdateByName";
}
//
//@GetMapping("updateByNameAndLoc/{restaurantName}")
//    public String updateByNameAndLoc(@PathVariable("restaurantName") String rName, Model model){
//
//        formService.searchByNameAndLoc(rName);
//
//
//        return "/UpdateByNameAndLoc.jsp";


    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

        viewResolver.setPrefix("/");
        viewResolver.setSuffix(".jsp");
        return  viewResolver;
    }

}


