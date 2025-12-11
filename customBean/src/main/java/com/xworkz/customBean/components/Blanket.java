package com.xworkz.customBean.components;

import lombok.*;
import org.springframework.stereotype.Component;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Blanket {
    private int id;
    private String material;
    private String color;
    private int size;
    private boolean lightweight;
    private int price;
    private String brand;
    private String type;
}
