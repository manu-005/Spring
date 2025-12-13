package com.xworkz.dependencyInjection.components.shirt;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;
@Setter
@Getter
@ToString
@Component
//@Scope("prototype")
public class Size {

    private int length;
    private int width;
}
