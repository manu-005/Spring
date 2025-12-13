package com.xworkz.dependencyInjection.components;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Setter
@Getter
//@ToString

@Component
@Scope("prototype")
public class Shirt {

    @Autowired
    Size size;

    @Value("black")
    private String color;

    @Value("499")
    private int price;

}
