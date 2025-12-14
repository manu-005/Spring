package com.xworkz.dependencyInjection.components.zoo;

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
public class Animal {
    @Value("Elephant")
    private String name;

    @Value("20")
    private int age;
}
