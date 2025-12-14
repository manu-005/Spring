package com.xworkz.dependencyInjection.components.company;

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
public class Employee {


    @Value("Bharath")
    private String empName;

    @Value("developer")
    private int role;

}
