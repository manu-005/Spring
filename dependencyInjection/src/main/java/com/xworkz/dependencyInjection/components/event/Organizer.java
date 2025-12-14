package com.xworkz.dependencyInjection.components.event;

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
public class Organizer {


    @Value("ZEE Kannada")
    private String organizerName;

    @Value("6")
    private int numberOfJudges;

}
