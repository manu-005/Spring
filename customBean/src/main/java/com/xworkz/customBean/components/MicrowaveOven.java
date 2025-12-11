package com.xworkz.customBean.components;

import lombok.*;
import org.springframework.stereotype.Component;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Component
public class MicrowaveOven {
    private int id;
    private String brand;
    private int capacity;
    private int power;
    private String color;
    private boolean convection;
    private int price;
    private String model;
}
