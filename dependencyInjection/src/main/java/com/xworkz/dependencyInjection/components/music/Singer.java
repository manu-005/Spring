package com.xworkz.dependencyInjection.components.music;

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
public class Singer {
    @Value("Janya ")
    private String name;

    @Value("kannada")
    private String language;
}
