package com.xworkz.passport.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassPortRegisterDTO {

    private int id;
    private String firstName;
    private String lastName;
    private String dob;

    private String userName;
    private String email;
    private String password;
private String confirmPassword;

    private String hintQuestion;
    private String hintAnswer;


}
