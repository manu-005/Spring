package com.xworkz.dependencyInjection.components.laptop;

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
public class Laptop {

    @Autowired
    Processor processor;

    @Value("dell")
    private String brand;

    @Value("10 th gen")
    private String gen;
}
