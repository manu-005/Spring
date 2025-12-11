package com.xworkz.customBean.components;

import lombok.*;
import org.springframework.stereotype.Component;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Speaker {
    private int id;
    private String brand;
    private String model;
    private int power;
    private boolean bluetooth;
    private boolean waterproof;
    private int price;
    private String color;
}
