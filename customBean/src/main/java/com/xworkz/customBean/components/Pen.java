package com.xworkz.customBean.components;

import lombok.*;
import org.springframework.stereotype.Component;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Pen {
    private int id;
    private String brand;
    private String inkColor;
    private String type;
    private int price;
    private boolean refillable;
    private String material;
    private String model;
}
