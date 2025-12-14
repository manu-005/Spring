package com.xworkz.dependencyInjection.components.softwareCompany;

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
public class Developer {
    @Value("mannoj")
    private String name;

    @Value("blueVendor")
    private String company;
}
