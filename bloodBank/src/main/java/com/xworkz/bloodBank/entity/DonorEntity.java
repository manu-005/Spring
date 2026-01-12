package com.xworkz.bloodBank.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="donorreg")
public class DonorEntity {

    @Id
    private int donorAccountId;
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "dob")
    private String dob;

    @Column(name = "userName")
    private String userName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "zip_code")
    private String zipCode;

    @Column(name = "password")
    private String password;

    @Column(name = "repeatePassword")
    private String repeatePassword;
}
