package com.xworkz.dependencyInjection.components.backery;

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
public class Oven {


    @Value("mini oven")
    private String ovenName;

    @Value("30")
    private int size;
}
