package com.xworkz.zomato.dto;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantDTO {

private String rName;
    private String rNo;
    private String loc;
    private String gstn;
    private String openDate;
    private String type;
    private String    landmark;
    private String email;
    private long oNo;
    private String oName;

}
