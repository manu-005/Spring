package com.xworkz.dependencyInjection.components.phone;

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
public class Battery {
    @Value("exides")
    private String name;

    @Value("9000")
    private String mah;
}
