package com.xworkz.dependencyInjection.components.church;

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
public class Pastor {

    @Value("sudeep")
    private String name;

    @Value("mysore")
    private String address;

}
