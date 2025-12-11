package com.xworkz.customBean.components;

import lombok.*;
import org.springframework.stereotype.Component;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Component
public class AirConditioner {
    private int id;
    private String brand;
    private int ton;
    private String type;
    private boolean inverter;
    private int price;
    private String model;
    private String color;
}
