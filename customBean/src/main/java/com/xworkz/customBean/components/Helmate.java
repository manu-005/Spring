package com.xworkz.customBean.components;

import lombok.*;
import org.springframework.stereotype.Component;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Helmate {
    private int id;
    private String brand;
    private String model;
    private String color;
    private boolean visor;
    private int price;
    private String material;
    private String size;
}
