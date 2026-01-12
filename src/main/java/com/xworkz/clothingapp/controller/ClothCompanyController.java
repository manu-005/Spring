package com.xworkz.clothingapp.controller;

import com.xworkz.clothingapp.dto.ClothDTO;
import com.xworkz.clothingapp.entity.ClothEntity;
import com.xworkz.clothingapp.service.ClothService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/")
@Controller
public class ClothCompanyController {

    @Autowired
    ClothService clothService;

    public ClothCompanyController() {
        System.out.println("controller object created");
    }


    @PostMapping("/clothRegister")
    public String clothRegister(ClothDTO dto, Model model) {
        System.out.println(dto);

        boolean saved = clothService.validateAndSave(dto);

        if (saved) {
            model.addAttribute("success", "Successfully Registered");
        } else {
            model.addAttribute("error", "Not Registered");
        }
        return "Registration";
    }

    @GetMapping("/search")
    public String getByName(String clothName,Model model){
        System.out.println(clothName);

       ClothDTO dto = clothService.getByName(clothName);

       if (dto.isAvailable()){
           model.addAttribute("list",dto);
       }else{
           model.addAttribute("error","Not found");
       }
        return "Search";
    }


    @GetMapping("/searchById")
    public String getById(int id,Model model){

       ClothDTO dto =  clothService.getById(id);

       if (dto.isAvailable()){
           model.addAttribute("list",dto);
       }else{
           model.addAttribute("error","Not found !");
       }
        return "SearchById";
    }
}
