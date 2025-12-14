package com.xworkz.dependencyInjection.components.university;

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
public class Faculty {

    @Value("Om ")
    private String name;

    @Value("18")
    private String yearsOfExperience;
}
