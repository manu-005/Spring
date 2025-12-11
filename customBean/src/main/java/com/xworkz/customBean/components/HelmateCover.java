package com.xworkz.customBean.components;

import lombok.*;
import org.springframework.stereotype.Component;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Component
public class HelmateCover {
    private int id;
    private String brand;
    private String color;
    private String material;
    private int price;
    private boolean waterproof;
    private String size;
    private String model;
}
