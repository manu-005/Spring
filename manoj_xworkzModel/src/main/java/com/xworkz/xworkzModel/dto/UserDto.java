package com.xworkz.xworkzModel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {


    private int id;


    @NotNull
    @Size(min = 4 , max = 10 ,message = "First Name size must be between 4 and 10")
    private String fName;

    @NotNull
    @Size(min = 4 , max = 10 ,message = "Last Name size must be between 4 and 10")
    private String lName;

    @NotNull
    @Min(value = 18 , message = "age must be greater than 18")
    @Max(value = 60 , message = "age must be less than 60")

    private int age;


    private String gender;

    @Pattern(regexp = " ")
    private String email;
    private long mobile;
    private String password;

}
