package com.xworkz.dependencyInjection.components.website;

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
public class Page {
    @Value("dynamic")
    private String type;

    @Value("8")
    private String navButtons;
}
