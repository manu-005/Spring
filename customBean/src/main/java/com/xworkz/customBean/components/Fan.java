package com.xworkz.customBean.components;

import lombok.*;
import org.springframework.stereotype.Component;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Fan {
    private int id;
    private String brand;
    private String type;
    private int speed;
    private String color;
    private int blades;
    private int price;
    private String model;
}
