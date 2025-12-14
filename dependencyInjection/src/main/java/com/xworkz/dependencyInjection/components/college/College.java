package com.xworkz.dependencyInjection.components.college;

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
public class College {
    @Autowired
    Department department;

    @Value("MDRS Svnr")
    private String collegeName;

    @Value("science")
    private String stream;
}
