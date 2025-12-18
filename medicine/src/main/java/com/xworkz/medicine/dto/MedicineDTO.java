package com.xworkz.medicine.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicineDTO {

    private String name;
    private double price;
    private String combination;
    private String mg;
    private String expireDate;

}
