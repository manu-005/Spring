package com.xworkz.customBean.components;

import lombok.*;
import org.springframework.stereotype.Component;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Component
public class WaterBottle {
    private int id;
    private String brand;
    private String material;
    private String color;
    private int capacity;
    private boolean insulated;
    private int price;
    private String ownerName;
}
