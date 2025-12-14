package com.xworkz.dependencyInjection.components.school;

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
public class ClassRoom {
    @Value("7")
    private int std;

    @Value("Tan")
    private String classTeacher;
}
