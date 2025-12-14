package com.xworkz.dependencyInjection.components.camera;

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
public class Lens {

    @Value("wide lens")
    private String lensName;


    @Value("23000")
    private int price;
}
