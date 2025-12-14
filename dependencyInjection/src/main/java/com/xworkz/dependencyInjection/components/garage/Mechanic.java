package com.xworkz.dependencyInjection.components.garage;

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
public class Mechanic {


    @Value("shabbir")
    private String name;

    @Value("28")
    private String age;
}
