package com.xworkz.dependencyInjection.components.cinema;

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
public class Screen {

    @Value("3")
    private int screenNumber;

    @Value("Balcony")
    private String seatType;

}
