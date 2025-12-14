package com.xworkz.dependencyInjection.components.orchestra;

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
public class Conductor {

    @Value("bharuuu")
    private String name;

    @Value("bhagalkote")
    private String from;
}
