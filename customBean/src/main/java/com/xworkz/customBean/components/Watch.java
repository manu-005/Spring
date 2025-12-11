package com.xworkz.customBean.components;

import lombok.*;
import org.springframework.stereotype.Component;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Watch {
    private int id;
    private String brand;
    private String model;
    private String color;
    private boolean waterproof;
    private int price;
    private String strapMaterial;
    private boolean smart;
}
