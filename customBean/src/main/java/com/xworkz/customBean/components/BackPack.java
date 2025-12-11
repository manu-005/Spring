package com.xworkz.customBean.components;

import lombok.*;
import org.springframework.stereotype.Component;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Component
public class BackPack {
    private int id;
    private String brand;
    private String color;
    private int capacity;
    private boolean laptopCompatible;
    private int price;
    private String material;
    private int pockets;
}
