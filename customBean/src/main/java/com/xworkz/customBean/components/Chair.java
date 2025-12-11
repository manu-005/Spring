package com.xworkz.customBean.components;

import lombok.*;
import org.springframework.stereotype.Component;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Chair {
    private int id;
    private String material;
    private String color;
    private String type;
    private boolean adjustable;
    private int price;
    private String brand;
    private String model;
}
