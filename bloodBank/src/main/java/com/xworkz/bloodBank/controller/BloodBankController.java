package com.xworkz.bloodBank.controller;

import com.xworkz.bloodBank.dto.BloodDonorDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class BloodBankController {


    public BloodBankController(){
        System.out.println("controller object created");
    }

    @PostMapping("/createAccount")
    public String  createDonorAccount(BloodDonorDTO bloodDonorDTO){


        return null;
    }
}
