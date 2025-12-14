package com.xworkz.dependencyInjection.components.temple;

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
public class God {
    @Value("durgadevi")
    private String name;

    @Value("female")
    private String gender;
}
