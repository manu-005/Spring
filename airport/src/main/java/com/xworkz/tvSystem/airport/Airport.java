package com.xworkz.tvSystem.airport;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Setter
@Getter
@ToString
@Component
public class Airport {


    private int aId;
    private String airportName;
    private String   loc;
}
