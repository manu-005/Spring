package com.xworkz.dependencyInjection.components.hostel;

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
public class Warden {

    @Value("Bharath")
    private String name;

    @Value("7 years")
    private String experience;
}
