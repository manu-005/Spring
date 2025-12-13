package com.xworkz.dependencyInjection.components.softwareCompany;

import com.xworkz.dependencyInjection.components.bike.Helmate;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Setter
@Getter
@ToString
@Component
@Scope("prototype")
public class SoftwareCompany {

    @Autowired
    Developer developer;

    @Value("name")
    private String companyName;

    @Value("2101")
    private int numberOfEmp;
}
