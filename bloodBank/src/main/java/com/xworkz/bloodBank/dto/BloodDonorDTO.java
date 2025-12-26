package com.xworkz.bloodBank.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BloodDonorDTO {
    private int donorAccountId;
    private String firstName;
    private String lastName;
    private String email;
    private String dob;
    private String userName;
    private String phone;
    private String zipCode;
    private String password;
    private String repeatePassword;
}
