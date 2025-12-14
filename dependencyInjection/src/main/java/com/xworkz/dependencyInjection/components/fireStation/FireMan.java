package com.xworkz.dependencyInjection.components.fireStation;

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
public class FireMan {


    @Value("sagar")
    private String firemanName;

    @Value("45")
    private int age;

}
