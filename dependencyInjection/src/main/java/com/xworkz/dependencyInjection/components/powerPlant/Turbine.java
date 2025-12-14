package com.xworkz.dependencyInjection.components.powerPlant;

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
public class Turbine {

    @Value("steam turbine")
    private String name;

    @Value("two blade")
    private String type;
}
