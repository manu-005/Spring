package com.xworkz.dependencyInjection.components.state;

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
public class District {
    @Value("mirchi")
    private String name;

    @Value("8")
    private String noOfTaluk;
}
