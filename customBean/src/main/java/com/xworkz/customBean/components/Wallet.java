package com.xworkz.customBean.components;

import lombok.*;
import org.springframework.stereotype.Component;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Wallet {
    private int id;
    private String brand;
    private String material;
    private String color;
    private int compartments;
    private int price;
    private boolean coinPocket;
    private String ownerName;
}
