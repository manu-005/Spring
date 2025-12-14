package com.xworkz.dependencyInjection.components.rocket;

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
public class Engine {
    @Value("liquid propellent engine")
    private String name;

    @Value("kerosene")
    private String reqOil;
}
