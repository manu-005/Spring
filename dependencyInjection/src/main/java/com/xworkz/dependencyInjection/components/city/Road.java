package com.xworkz.dependencyInjection.components.city;

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
public class Road {
    @Value("MG Road")
    private String roadName;

    @Value("6")
    private String lanes;

}
