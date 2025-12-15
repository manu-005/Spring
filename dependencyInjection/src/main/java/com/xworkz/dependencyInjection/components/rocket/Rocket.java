package com.xworkz.dependencyInjection.components.rocket;

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
public class Rocket {

    @Autowired
    RocketEngine rocketEngine;

    @Value("rockey")
    private String rocketName;

    @Value("31-04-2009")
    private String launchDate;
}
