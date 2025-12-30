package com.xworkz.eventSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventDto {

    private  int id;
    private String eventName;
    private String location;
    private String time;
    private String manager;

}
