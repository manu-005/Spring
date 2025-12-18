package com.xworkz.medicine.config;

import com.xworkz.medicine.controller.MedicineController;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@ComponentScan(basePackages = "com.xworkz.medicine")
@Configuration
public class MedicineConfiguration {

    public MedicineConfiguration(){
        System.out.println("config object..");
    }
}
