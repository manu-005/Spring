package com.xworkz.customBean.components;

import lombok.*;
import org.springframework.stereotype.Component;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Television {
    private int id;
    private String brand;
    private String model;
    private int size;
    private String displayType;
    private boolean smartTv;
    private int price;
    private String ownerName;
}
