package com.xworkz.customBean.components;

import lombok.*;
import org.springframework.stereotype.Component;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Camera {
    private int id;
    private String brand;
    private String model;
    private int megapixel;
    private boolean dslr;
    private int price;
    private String lensType;
    private String color;
}
