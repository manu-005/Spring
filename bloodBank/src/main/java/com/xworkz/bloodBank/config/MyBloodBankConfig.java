package com.xworkz.bloodBank.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.xworkz.bloodBank")
public class MyBloodBankConfig {

    public MyBloodBankConfig(){
        System.out.println("my blood bank config object created");
    }

}
