package com.xworkz.clothCompany.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClothDto {

    private int id;
    private String name;
    private String type;
    private Double price;
    private String size;
    private String color;
    private String brand;
    private String material;

}
