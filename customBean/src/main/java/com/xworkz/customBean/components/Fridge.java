package com.xworkz.customBean.components;

import lombok.*;
import org.springframework.stereotype.Component;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Fridge {
    private int id;
    private String brand;
    private int capacity;
    private String type;
    private String color;
    private int price;
    private boolean inverter;
    private String ownerName;
}
