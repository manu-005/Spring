package com.xworkz.dependencyInjection.components.shirt;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Setter
@Getter
@ToString
@Component
//@Scope("prototype")
public class Size {

    @Value("32")
    private int length;

    @Value("40")
    private int width;
}
