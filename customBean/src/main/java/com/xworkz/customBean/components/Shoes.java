package com.xworkz.customBean.components;

import lombok.*;
import org.springframework.stereotype.Component;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Shoes {
    private int id;
    private String brand;
    private String type;
    private String color;
    private int size;
    private int price;
    private String material;
    private String ownerName;
}
