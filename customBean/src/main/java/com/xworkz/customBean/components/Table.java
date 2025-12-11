package com.xworkz.customBean.components;

import lombok.*;
import org.springframework.stereotype.Component;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Table {
    private int id;
    private String material;
    private String color;
    private int height;
    private int width;
    private int price;
    private String brand;
    private boolean foldable;
}
