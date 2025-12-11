package com.xworkz.customBean.components;

import lombok.*;
import org.springframework.stereotype.Component;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Pillow {
    private int id;
    private String material;
    private String size;
    private String color;
    private int price;
    private boolean washable;
    private String type;
    private String brand;
}
