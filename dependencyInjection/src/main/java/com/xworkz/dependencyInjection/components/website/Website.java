package com.xworkz.dependencyInjection.components.website;

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
public class Website {

    @Autowired
    Page page;

    @Value("former web app")
    private String name;

    @Value("green")
    private String theme;
}
