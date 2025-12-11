package com.xworkz.customBean.components;

import lombok.*;
import org.springframework.stereotype.Component;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Router {
    private int id;
    private String brand;
    private String model;
    private int speed;
    private boolean dualBand;
    private int price;
    private int antennas;
    private String color;
}
