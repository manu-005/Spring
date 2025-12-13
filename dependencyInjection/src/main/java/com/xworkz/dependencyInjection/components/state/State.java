package com.xworkz.dependencyInjection.components.state;

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
public class State {

    @Autowired
    District district;

    @Value("Karnataka")
    private String stateName;

    @Value("30")
    private int noOfDistrict;
}
