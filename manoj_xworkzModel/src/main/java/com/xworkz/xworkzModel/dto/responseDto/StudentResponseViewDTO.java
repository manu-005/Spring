package com.xworkz.xworkzModel.dto.responseDto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponseViewDTO {
    private String studentName;
    private String email;
    private String response;

    // getters & setters
}
