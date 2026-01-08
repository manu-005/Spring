package com.xworkz.clothCompany.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ClothEntity {

    @Id
    private int id;
    private String name;
    private String type;
    private Double price;
    private String size;
    private String color;
    private String brand;
    private String material;
    private Boolean isSustainable;
}
