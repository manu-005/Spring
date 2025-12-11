package com.xworkz.customBean.components;

import lombok.*;
import org.springframework.stereotype.Component;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Bed {
    private int id;
    private String material;
    private String size;
    private String color;
    private int price;
    private boolean storage;
    private String design;
    private String brand;
}
