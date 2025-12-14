package com.xworkz.dependencyInjection.components.bus;

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
public class Driver {

    @Value("Manoj")
    private String driverName;

    @Value("45000")
    private int salary;
}

