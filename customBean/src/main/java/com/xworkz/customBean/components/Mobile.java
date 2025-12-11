package com.xworkz.customBean.components;

import lombok.*;
import org.springframework.stereotype.Component;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Mobile {
    private int id;
    private String brand;
    private String model;
    private double price;
    private int ram;
    private int storage;
    private String color;
    private String ownerName;
}
