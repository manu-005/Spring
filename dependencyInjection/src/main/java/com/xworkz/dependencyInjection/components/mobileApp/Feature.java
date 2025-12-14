package com.xworkz.dependencyInjection.components.mobileApp;

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
public class Feature {
    @Value("16 gb")
    private String ram;

    @Value("512 gb")
    private String rom;
}
