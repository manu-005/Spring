package com.xworkz.dependencyInjection.components.factory;

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
public class Machine {


    @Value("M1")
    private String machine;

    @Value("15")
    private int numberOfMachines;

}
