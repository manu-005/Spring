package com.xworkz.customBean.components;

import lombok.*;
import org.springframework.stereotype.Component;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Printer {
    private int id;
    private String brand;
    private String model;
    private boolean colorPrinter;
    private boolean wireless;
    private int speed;
    private int price;
    private String type;
}
