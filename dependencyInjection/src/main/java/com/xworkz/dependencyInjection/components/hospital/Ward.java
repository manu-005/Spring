package com.xworkz.dependencyInjection.components.hospital;

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
public class Ward {


    @Value("1")
    private String wardNumber;

    @Value("emergency")
    private String wardName;
}
