package com.xworkz.studio.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class StudioEntity {

    @Id
    private  int id;
    private String customerName;
    private String email;
    private long mobileNo;
    private String bookingFor;
    private String location;

}
