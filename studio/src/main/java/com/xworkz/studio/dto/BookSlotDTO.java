package com.xworkz.studio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookSlotDTO {

    private  int id;
    private String customerName;
    private String email;
    private long mobileNo;
    private String bookingFor;
    private String location;


}

