package com.xworkz.customBean.components;

import lombok.*;
import org.springframework.stereotype.Component;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Headphone {
    private int id;
    private String brand;
    private String model;
    private boolean wireless;
    private int batteryLife;
    private String color;
    private int price;
    private boolean noiseCancellation;
}
