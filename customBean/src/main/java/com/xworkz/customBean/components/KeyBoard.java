package com.xworkz.customBean.components;

import lombok.*;
import org.springframework.stereotype.Component;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Component
public class KeyBoard {
    private int id;
    private String brand;
    private String type;
    private boolean wireless;
    private String color;
    private int price;
    private String layout;
    private String model;
}
