package com.xworkz.medicine.controller;

import com.xworkz.medicine.dao.MedicineDAOImpl;
import com.xworkz.medicine.dto.MedicineDTO;
import com.xworkz.medicine.service.MedicineService;
import com.xworkz.medicine.service.MedicineServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Component
@RequestMapping("/")
public class MedicineController {

    public MedicineController() {
        System.out.println("Medicine controller Object created");
    }

    @Autowired
    MedicineService medicineService;

    @PostMapping("/addMedicine")
    public String addMedicine(MedicineDTO dto) {
        System.out.println(dto);

        boolean saved = medicineService.validateAndSave(dto);
        System.out.println(saved);
        if (!saved) {

            System.out.println("saved success fully");
            return "response";
        } else return "error";
    }
@PostMapping("/delete")
    public String delete( String name, Model model){

        System.out.println(name);

       boolean deleted = medicineService.delete(name);
       if (deleted){
           model.addAttribute("success","Deleted Successfully..!");
       }else{
           model.addAttribute("error","Not deleted, Try again after sometime..!");

       }
        return "index";
    }

@Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

        viewResolver.setPrefix("/");
        viewResolver.setSuffix(".jsp");
    return  viewResolver;
    }

}
