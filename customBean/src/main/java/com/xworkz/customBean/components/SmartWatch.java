package com.xworkz.customBean.components;

import lombok.*;
import org.springframework.stereotype.Component;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Component
public class SmartWatch {
    private int id;
    private String brand;
    private String model;
    private double price;
    private String color;
    private boolean waterResistant;
    private boolean gps;
    private int batteryLife;
}
