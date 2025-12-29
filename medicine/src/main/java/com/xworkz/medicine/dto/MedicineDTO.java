package com.xworkz.medicine.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "medicine")
public class MedicineDTO {

    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private double price;

    @Column(name = "combination")
    private String combination;

    @Column(name = "mg")
    private String mg;

    @Column(name = "expireDate")
    private String expireDate;

}
