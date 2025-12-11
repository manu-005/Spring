package com.xworkz.customBean.components;


import lombok.*;
import org.springframework.stereotype.Component;

@Setter
@Getter
@ToString
@AllArgsConstructor
@Component
@NoArgsConstructor
public class Laptop {

    private int id;
    private String name;
    private String model;
    private String brand;
    private String series;
    private String ownerName;
    private int price;
    private int ram;

}
