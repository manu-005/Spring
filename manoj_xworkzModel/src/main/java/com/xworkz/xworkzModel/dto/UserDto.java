package com.xworkz.xworkzModel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private int id;
    private String fName;
    private String lName;
    private int age;
    private String gender;
    private String email;
    private long mobile;
    private String password;

}
