package com.xworkz.eventSystem.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EventEntity {

    @Id
    private  int id;
    private String eventName;
    private String location;
    private String time;
    private String manager;


}
