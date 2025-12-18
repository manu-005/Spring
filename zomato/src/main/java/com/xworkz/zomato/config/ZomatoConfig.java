package com.xworkz.zomato.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
@Configuration
@ComponentScan(basePackages = "com.xworkz.zomato")

public class ZomatoConfig {
    public ZomatoConfig(){
        System.out.println("config object created");
    }

}
