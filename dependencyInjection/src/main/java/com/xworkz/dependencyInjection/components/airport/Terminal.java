package com.xworkz.dependencyInjection.components.airport;


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
public class Terminal {

    @Value("South")
    private String terminalName;

    @Value("102")
    private int terminalNumber;

}
