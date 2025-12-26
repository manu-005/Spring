package com.xworkz.passport.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.xworkz.passport")
public class PassPortConfig {
    public PassPortConfig(){
        System.out.println("coonfig object created");
    }

}
