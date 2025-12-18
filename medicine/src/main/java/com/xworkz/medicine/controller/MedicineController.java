package com.xworkz.medicine.controller;

import com.xworkz.medicine.dao.MedicineDAOImpl;
import com.xworkz.medicine.dto.MedicineDTO;
import com.xworkz.medicine.service.MedicineService;
import com.xworkz.medicine.service.MedicineServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/")
public class MedicineController {

    public MedicineController(){
        System.out.println("Medicine controller Object created");
    }
@Autowired
MedicineService medicineService;

    @PostMapping("/addMedicine")
 public String addMedicine(MedicineDTO dto){
        System.out.println(dto);

boolean saved = medicineService.validateAndSave(dto);
        System.out.println(saved);
if (!saved){

    System.out.println("saved success fully");
    return "response.jsp";
}
else return "error.jsp";
 }
}
