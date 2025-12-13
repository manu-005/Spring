package com.xworkz.dependencyInjection.components.airport;

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
public class Airport {

    @Autowired
    Terminal terminal;

    @Value("KIA")
    private String name;

    @Value("Devanahalli")
    private String loc;

}
