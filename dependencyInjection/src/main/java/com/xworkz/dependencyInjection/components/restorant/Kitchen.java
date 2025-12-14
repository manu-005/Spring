package com.xworkz.dependencyInjection.components.restorant;

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
public class Kitchen {

    @Value("veg")
    private String name;

    @Value("2")
    private String number;
}
