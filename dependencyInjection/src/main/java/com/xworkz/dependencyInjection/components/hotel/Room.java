package com.xworkz.dependencyInjection.components.hotel;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Setter
@Getter
@ToString
@Component
@Scope("prototype")
public class Room {


    @Value("AC room")
    private String roomType;

    @Value("101")
    private int roomNumber;
}
