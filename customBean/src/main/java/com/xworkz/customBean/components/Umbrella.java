package com.xworkz.customBean.components;

import lombok.*;
import org.springframework.stereotype.Component;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Umbrella {
    private int id;
    private String color;
    private String type;
    private String brand;
    private int price;
    private boolean automatic;
    private String material;
    private int size;
}
