package com.xworkz.customBean.components;

import lombok.*;
import org.springframework.stereotype.Component;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Cupboard {
    private int id;
    private String material;
    private int shelves;
    private String color;
    private boolean lock;
    private int price;
    private String brand;
    private String model;
}
