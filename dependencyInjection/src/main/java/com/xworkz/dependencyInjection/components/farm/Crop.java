package com.xworkz.dependencyInjection.components.farm;

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
public class Crop {


    @Value("Peanut")
    private String cropName;

    @Value("legume crop")
    private int cropType;

}
