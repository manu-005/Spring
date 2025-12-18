package com.xworkz.zomato.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@AllArgsConstructor@NoArgsConstructor

public class CheckExistEmailDTO {

    private String email;

}
