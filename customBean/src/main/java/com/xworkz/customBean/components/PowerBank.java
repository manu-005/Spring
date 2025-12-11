package com.xworkz.customBean.components;

import lombok.*;
import org.springframework.stereotype.Component;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Component
public class PowerBank {
    private int id;
    private String brand;
    private int capacity;
    private boolean fastCharging;
    private String color;
    private int price;
    private int weight;
    private String model;
}
