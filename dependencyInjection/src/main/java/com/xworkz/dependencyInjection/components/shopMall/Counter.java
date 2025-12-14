package com.xworkz.dependencyInjection.components.shopMall;

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
public class Counter {

    @Value("bill counter")
    private String name;

    @Value("digital")
    private String counterType;
}
