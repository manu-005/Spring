package com.xworkz.dependencyInjection.components.car;

import com.xworkz.dependencyInjection.components.bike.Helmate;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Setter
@Getter
@ToString
@Component
@Scope("prototype")
public class Car {

    @Autowired
    Wheel wheel;

    @Value("Toyota")
    private String carName;

    @Value("CNG")
    private String carType;
}
