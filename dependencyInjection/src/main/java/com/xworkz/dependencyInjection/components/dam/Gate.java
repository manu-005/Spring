package com.xworkz.dependencyInjection.components.dam;

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
public class Gate {
    @Value("two tier gates")
    private String gateName;

    @Value("152")
    private int numberOfGates;

}
