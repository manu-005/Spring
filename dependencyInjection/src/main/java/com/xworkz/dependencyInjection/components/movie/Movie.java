package com.xworkz.dependencyInjection.components.movie;

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
public class Movie {

    @Autowired
    Hero hero;

    @Value("Rajkumar")
    private String movieName;

    @Value("kannada")
    private String longuage;
}
