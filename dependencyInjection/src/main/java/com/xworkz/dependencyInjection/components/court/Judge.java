package com.xworkz.dependencyInjection.components.court;

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
public class Judge {

    @Value("Shree Murthi")
    private String judgeName;

    @Value("male")
    private String gender;

}
