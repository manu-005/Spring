package com.xworkz.dependencyInjection.components.zoo;

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
public class Zoo {

    @Autowired
    Animal animal;

    @Value("national zoo")
    private String name;

    @Value("mysore")
    private String location;
}
