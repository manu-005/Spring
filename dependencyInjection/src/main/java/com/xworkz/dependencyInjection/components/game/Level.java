package com.xworkz.dependencyInjection.components.game;

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
public class Level {


    @Value("100")
    private String cap;

    @Value("200 matches")
    private String experience;
}
