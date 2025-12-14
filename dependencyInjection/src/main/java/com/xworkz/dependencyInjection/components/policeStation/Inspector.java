package com.xworkz.dependencyInjection.components.policeStation;

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
public class Inspector {
    @Value("Sharath")
    private String name;

    @Value("45")
    private String age;
}
