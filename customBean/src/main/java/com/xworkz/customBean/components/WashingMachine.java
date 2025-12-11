package com.xworkz.customBean.components;

import lombok.*;
import org.springframework.stereotype.Component;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Component
public class WashingMachine {
    private int id;
    private String brand;
    private String type;
    private int capacity;
    private String color;
    private int price;
    private boolean automatic;
    private String model;
}
